package gyqw.xiaobaitu.distance;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.Iterator;

/**
 * @author fred
 * @date 2018/06/25 11:47
 */
public class AnsjSegMain {
    public static void main(String[] args) {
        String address = "湖北省 武汉市 东西湖区革新大道四明路物流园c5门";
        System.out.println(ToAnalysis.parse(address));
        String company = "北京花旺在线商贸有限公司";
        Iterator<Term> result = ToAnalysis.parse(company).iterator();
        while (result.hasNext()) {
            System.out.println(result.next().getName());
        }
    }
}
