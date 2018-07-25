package gyqw.xiaobaitu.drools.model;

import java.io.Serializable;

/**
 * @author fred
 * @date 2018/07/25 13:55
 */
public class AppInfoModel implements Serializable {
    private String houseHoldAddressCity;
    private String storeAddressCity;
    private int age;

    public String getHouseHoldAddressCity() {
        return houseHoldAddressCity;
    }

    public void setHouseHoldAddressCity(String houseHoldAddressCity) {
        this.houseHoldAddressCity = houseHoldAddressCity;
    }

    public String getStoreAddressCity() {
        return storeAddressCity;
    }

    public void setStoreAddressCity(String storeAddressCity) {
        this.storeAddressCity = storeAddressCity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AppInfoModel{" +
                "houseHoldAddressCity='" + houseHoldAddressCity + '\'' +
                ", storeAddressCity='" + storeAddressCity + '\'' +
                ", age=" + age +
                '}';
    }
}
