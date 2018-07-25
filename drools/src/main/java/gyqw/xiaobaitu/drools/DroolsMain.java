package gyqw.xiaobaitu.drools;

import gyqw.xiaobaitu.drools.model.AppInfoModel;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author fred
 * @date 2018/07/25 13:05
 */
public class DroolsMain {
    public static void main(String[] args) {
        try {
            AppInfoModel appInfoModel = new AppInfoModel();
            appInfoModel.setAge(99);

            KieServices kss = KieServices.Factory.get();
            KieContainer kc = kss.getKieClasspathContainer();

            KieSession ks = kc.newKieSession();
            ks.insert(appInfoModel);
            int firedRules = ks.fireAllRules();
            System.out.println(firedRules);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
