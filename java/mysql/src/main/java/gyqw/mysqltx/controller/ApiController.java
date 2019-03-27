package gyqw.mysqltx.controller;

import gyqw.mysqltx.domain.FundSendDetails;
import gyqw.mysqltx.mapper.FundSendDetailsMapper;
import gyqw.mysqltx.model.SendModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author fred
 * 2019-03-27 4:59 PM
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    private FundSendDetailsMapper fundSendDetailsMapper;

    @Autowired
    public void setFundSendDetailsMapper(FundSendDetailsMapper fundSendDetailsMapper) {
        this.fundSendDetailsMapper = fundSendDetailsMapper;
    }

    @RequestMapping("/send")
    public SendModel send() {
        int i = 0;
        do {
            try {
                String sysTerno = UUID.randomUUID().toString().replace("-", "");

                // 插入
                FundSendDetails fundSendDetails = new FundSendDetails();
                fundSendDetails.setSysSerno(sysTerno);
                fundSendDetails.setAppId("setAppId");
                fundSendDetails.setApplySerno("setApplySerno");
                fundSendDetails.setProductType("t");
                fundSendDetails.setSendRecordSysSerno("setSendRecordSysSerno");
                fundSendDetails.setFundId("setFundId");
                fundSendDetails.setFundName("setFundName");
                fundSendDetails.setSendStatus("s");
                fundSendDetails.setSendTime(new Date());
                this.fundSendDetailsMapper.insert(fundSendDetails);

                // 更新
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                fundSendDetails = new FundSendDetails();
                fundSendDetails.setUpdateTime(sdf.parse("2019-03-01 10:00:12"));
                Condition condition = new Condition(FundSendDetails.class);
                condition.createCriteria()
                        .andEqualTo("sysSerno", sysTerno);
                this.fundSendDetailsMapper.updateByExampleSelective(fundSendDetails, condition);

            } catch (Exception e) {
                logger.error("send error", e);
            }

            i++;
        } while (i < 10000);

        return new SendModel();
    }
}
