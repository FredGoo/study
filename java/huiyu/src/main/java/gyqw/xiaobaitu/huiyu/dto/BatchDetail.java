package gyqw.xiaobaitu.huiyu.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 计划明细 by kevin.yao
 */
public class BatchDetail {
    // 产品名称
    private String productname;
    // 用户名称
    private String username;
    // 性别 男、女
    private String sex;
    // 电话
    private String phone;
    // 借款金额
    private BigDecimal loanamount;
    // 逾期天数
    private Integer laterday;
    // 逾期费
    private BigDecimal lateramount;
    // 客服电话
    private String servicesphone;
    //扩展字段集合
    private List<Map<String, Object>> publiccolumn;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(BigDecimal loanamount) {
        this.loanamount = loanamount;
    }

    public Integer getLaterday() {
        return laterday;
    }

    public void setLaterday(Integer laterday) {
        this.laterday = laterday;
    }

    public BigDecimal getLateramount() {
        return lateramount;
    }

    public void setLateramount(BigDecimal lateramount) {
        this.lateramount = lateramount;
    }

    public String getServicesphone() {
        return servicesphone;
    }

    public void setServicesphone(String servicesphone) {
        this.servicesphone = servicesphone;
    }

    public List<Map<String, Object>> getPubliccolumn() {
        return publiccolumn;
    }

    public void setPubliccolumn(List<Map<String, Object>> publiccolumn) {
        this.publiccolumn = publiccolumn;
    }

    @Override
    public String toString() {
        return "BatchDetail{" +
                "productname='" + productname + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", loanamount=" + loanamount +
                ", laterday=" + laterday +
                ", lateramount=" + lateramount +
                ", servicesphone='" + servicesphone + '\'' +
                ", publiccolumn=" + publiccolumn +
                '}';
    }
}
