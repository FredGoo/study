package huiyu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import huiyu.dto.*;
import huiyu.service.AiRequest;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author fred
 * 2018-10-31 5:47 PM
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        AiRequest aiRequest = new AiRequest();

        String batchNo = "190209001292";
        if (args.length > 0 && !StringUtils.isEmpty(args[0])) {
            batchNo = args[0];
        } else {
            logger.error("请输入批次号");
            return;
        }

        int page = 1;
        int size = 100;
        int realSize = 0;
        List<ExcelRow> excelRowList = new ArrayList<>();

        do {
            try {
                // 获取列表
                BaseResult baseResult = aiRequest.queryList(batchNo, page, size);
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                ReturnBatchData batchData = gson.fromJson(baseResult.getData().toString(), ReturnBatchData.class);
                realSize = batchData.getList().size();
                logger.info("total: " + batchData.getCount() + ", page: " + page + ", size: " + realSize);

                // 遍历详细信息
                for (ReturnBatchItem batchItem : batchData.getList()) {
                    // excel数据行
                    ExcelRow excelRow = new ExcelRow();
                    excelRow.setCallStatus(batchItem.getCallstatus());
                    excelRow.setCallDuration(batchItem.getTalktime());
                    excelRow.setPhone(batchItem.getPhone());
                    excelRow.setIntent(batchItem.getIntent());
                    excelRow.setCallTime(batchItem.getCalltime());

                    BaseResult detailResult = aiRequest.queryDetail(batchNo, batchItem.getPhone());
                    if (detailResult.getCode() > 0) {
                        ReturnBatchDetail returnBatchDetail = gson.fromJson(detailResult.getData().toString(), ReturnBatchDetail.class);

                        // 遍历通话内容
                        StringBuilder sb = new StringBuilder();
                        for (ReturnBatchDetailItem returnBatchDetailItem : returnBatchDetail.getList()) {
                            if (!StringUtils.isEmpty(returnBatchDetailItem.getAtext())) {
                                sb.append("机器： ").append(returnBatchDetailItem.getAtext()).append("\n\r");
                            } else if (!StringUtils.isEmpty(returnBatchDetailItem.getBtext())) {
                                sb.append("客户： ").append(returnBatchDetailItem.getBtext()).append("\n\r");
                            }
                        }

                        // excel数据行
                        excelRow.setCallContent(sb.toString());
                    }

                    excelRowList.add(excelRow);
                }

                page++;
                sleep(10);
            } catch (Exception e) {
                logger.error("batchNo: " + batchNo + ", page: " + page, e);
            }
        } while (realSize >= size);
//        } while (1 != 1);

        // 保存excel
        try {
            File file = new File(batchNo + ".xlsx");
            OutputStream outputStream = new FileOutputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook();

            // 换行样式
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setWrapText(true);

            // 日期样式
            XSSFCellStyle cellStyle2 = workbook.createCellStyle();
            XSSFCreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle2.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);

            XSSFSheet sheet = workbook.createSheet("Sheet1");
            sheet.setColumnWidth(6, 200 * 256);
            XSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("批次号");
            row.createCell(1).setCellValue("手机");
            row.createCell(2).setCellValue("意愿");
            row.createCell(3).setCellValue("呼叫时间");
            row.createCell(4).setCellValue("呼叫状态");
            row.createCell(5).setCellValue("通话时长");
            row.createCell(6).setCellValue("通话内容");

            int rowNum = 1;
            for (ExcelRow excelRow : excelRowList) {
                XSSFRow row1 = sheet.createRow(rowNum);

                row1.createCell(0).setCellValue(batchNo);
                row1.createCell(1).setCellValue(excelRow.getPhone());
                row1.createCell(2).setCellValue(excelRow.getIntent());
                XSSFCell cell3 = row1.createCell(3);
                cell3.setCellStyle(cellStyle2);
                cell3.setCellValue(excelRow.getCallTime());
                row1.createCell(4).setCellValue(excelRow.getCallStatus());
                row1.createCell(5).setCellValue(excelRow.getCallDuration());
                XSSFCell cell6 = row1.createCell(6);
                cell6.setCellStyle(cellStyle);
                cell6.setCellValue(new XSSFRichTextString(excelRow.getCallContent()));

                rowNum++;
            }

            workbook.setActiveSheet(0);
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            logger.error("jxl error", e);
        }
    }
}
