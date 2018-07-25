package gyqw.xiaobaitu.drools;

import gyqw.xiaobaitu.drools.model.AppInfoModel;
import org.kie.api.KieServices;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

/**
 * @author fred
 * @date 2018/07/25 13:05
 */
public class DroolsMain {
    public static void main(String[] args) {
        DroolsMain droolsMain = new DroolsMain();
        KieSession kieSession = droolsMain.fromString();

        try {
            AppInfoModel appInfoModel = new AppInfoModel();
            appInfoModel.setAge(99);

            kieSession.insert(appInfoModel);
            int firedRules = kieSession.fireAllRules();
            System.out.println(firedRules);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private KieSession fromString() {
        String drl = "package gyqw.xiaobaitu.drools;\n" +
                "\n" +
                "import gyqw.xiaobaitu.drools.model.AppInfoModel;\n" +
                "\n" +
                "        rule \"old-lady\"\n" +
                "            salience 1\n" +
                "            when\n" +
                "                $p : AppInfoModel(age > 40);\n" +
                "            then\n" +
                "                $p.setHouseHoldAddressCity(\"少年\");\n" +
                "                retract($p);\n" +
                "                System.out.println($p.getStoreAddressCity()+\" \"+$p.getHouseHoldAddressCity());\n" +
                "        end";
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);

        Results results = kieHelper.verify();
        System.out.println(results);

        return kieHelper.build().newKieSession();
    }

    private KieSession fromResource() {
        try {
            KieServices kss = KieServices.Factory.get();
            KieContainer kc = kss.getKieClasspathContainer();

            return kc.newKieSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
