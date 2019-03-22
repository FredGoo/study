package gyqw.playground.hanlp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hankcs.hanlp.mining.cluster.ClusterAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author fred
 * 2019-03-21 4:07 PM
 */
public class HanlpMain {
    private Logger logger = LoggerFactory.getLogger(HanlpMain.class);

    public static void main(String[] args) {
        HanlpMain hanlpMain = new HanlpMain();
        hanlpMain.sms();
    }

    private void manSound() {
        ClusterAnalyzer<String> analyzer = new ClusterAnalyzer<>();
        analyzer.addDocument("赵一", "流行, 流行, 流行, 流行, 流行, 流行, 流行, 流行, 流行, 流行, 蓝调, 蓝调, 蓝调, 蓝调, 蓝调, 蓝调, 摇滚, 摇滚, 摇滚, 摇滚");
        analyzer.addDocument("钱二", "爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲");
        analyzer.addDocument("张三", "古典, 古典, 古典, 古典, 民谣, 民谣, 民谣, 民谣");
        analyzer.addDocument("李四", "爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 爵士, 金属, 金属, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲, 舞曲");
        analyzer.addDocument("王五", "流行, 流行, 流行, 流行, 摇滚, 摇滚, 摇滚, 嘻哈, 嘻哈, 嘻哈");
        analyzer.addDocument("马六", "古典, 古典, 古典, 古典, 古典, 古典, 古典, 古典, 摇滚");

        logger.info(analyzer.repeatedBisection(1.0).toString());
    }

    private void sms() {
        try {
            // 读取数据文件
            BufferedReader br = new BufferedReader(new FileReader("data/test/sms/customer.json"));
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            while ((s = br.readLine()) != null) {
                stringBuilder.append(s);
            }
            br.close();
            logger.info("原始json: " + stringBuilder.toString());

            ClusterAnalyzer<String> analyzer = new ClusterAnalyzer<>();
            Gson gson = new Gson();
            Map<String, String> smsMap = new HashMap<>();
            List<Map<String, String>> list = gson.fromJson(stringBuilder.toString(), new TypeToken<List<Map<String, String>>>() {
            }.getType());
            for (Map<String, String> map : list) {
                analyzer.addDocument(map.get("ID"), map.get("SMS_CONTENT"));
                smsMap.put(map.get("ID"), map.get("SMS_CONTENT"));
            }
            List<Set<String>> analyzerRes = analyzer.repeatedBisection(1.0);

            // 遍历结果
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/test/sms/result.txt"));
            int group = 0;
            for (Set<String> set : analyzerRes) {
                bw.write("group" + group);
                bw.newLine();

                for (String s1 : set) {
                    bw.write("ID: " + s1 + ", SMS_CONTENT: " + smsMap.get(s1));
                    bw.newLine();
                }

                bw.newLine();
                group++;
            }
            bw.close();
        } catch (Exception e) {
            logger.error("sms error", e);
        }
    }
}
