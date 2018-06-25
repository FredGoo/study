package gyqw.xiaobaitu.distance;

import org.ansj.splitWord.analysis.ToAnalysis;

/**
 * @author fred
 * @date 2018/06/25 11:47
 */
public class AnsjSegMain {
    public static void main(String[] args) {
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!";
        System.out.println(ToAnalysis.parse(str));
        String address = "湖北省 武汉市 东西湖区革新大道四明路物流园c5门";
        System.out.println(ToAnalysis.parse(address));
        String company = "即科金融信息服务(上海)有限公司";
        System.out.println(ToAnalysis.parse(company));
    }
}
