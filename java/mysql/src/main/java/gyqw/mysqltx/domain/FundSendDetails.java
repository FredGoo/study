package gyqw.mysqltx.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "FUND_SEND_DETAILS")
public class FundSendDetails implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统流水号
     */
    @Column(name = "SYS_SERNO")
    private String sysSerno;

    /**
     * 申请订单号
     */
    @Column(name = "APP_ID")
    private String appId;

    /**
     * 进件流水
     */
    @Column(name = "APPLY_SERNO")
    private String applySerno;

    /**
     * 产品类型 CH:现金代,WK:无卡
     */
    @Column(name = "PRODUCT_TYPE")
    private String productType;

    /**
     * 外部资金方进件流水
     */
    @Column(name = "EXTERNAL_FUND_APPLY_SERNO")
    private String externalFundApplySerno;

    /**
     * 推送记录系统流水号FUND_SEND_RECORD表SYS_SERNO
     */
    @Column(name = "SEND_RECORD_SYS_SERNO")
    private String sendRecordSysSerno;

    /**
     * 资金方标志
     */
    @Column(name = "FUND_ID")
    private String fundId;

    /**
     * 资金方名称
     */
    @Column(name = "FUND_NAME")
    private String fundName;

    /**
     * 推送状态 S：推送成功，F：推送失败，N：待推送
     */
    @Column(name = "SEND_STATUS")
    private String sendStatus;

    /**
     * 返回码
     */
    @Column(name = "SEND_TIME")
    private Date sendTime;

    /**
     * 实际贷款金额 贴息倒算订单 实贷本金不一致
     */
    @Column(name = "REAL_LOAN_AMOUNT")
    private BigDecimal realLoanAmount;

    /**
     * 用户实际付息比例
     */
    @Column(name = "REAL_PERCENT_USER")
    private BigDecimal realPercentUser;

    /**
     * 即科分润比例
     */
    @Column(name = "SPLIT_RATE")
    private BigDecimal splitRate;

    /**
     * 资金方产品类型 WK001：无卡默认产品 WK002：无卡贴息产品 CASH001：现金贷默认产品 默认值：WK001
     */
    @Column(name = "FUND_PRODUCT_TYPE")
    private String fundProductType;

    /**
     * 资金方返回码
     */
    @Column(name = "FUND_RSP_CODE")
    private String fundRspCode;

    /**
     * 资金方返回信息
     */
    @Column(name = "FUND_RSP_MSG")
    private String fundRspMsg;

    /**
     * 创建者
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取系统流水号
     *
     * @return SYS_SERNO - 系统流水号
     */
    public String getSysSerno() {
        return sysSerno;
    }

    /**
     * 设置系统流水号
     *
     * @param sysSerno 系统流水号
     */
    public void setSysSerno(String sysSerno) {
        this.sysSerno = sysSerno == null ? null : sysSerno.trim();
    }

    /**
     * 获取申请订单号
     *
     * @return APP_ID - 申请订单号
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置申请订单号
     *
     * @param appId 申请订单号
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取进件流水
     *
     * @return APPLY_SERNO - 进件流水
     */
    public String getApplySerno() {
        return applySerno;
    }

    /**
     * 设置进件流水
     *
     * @param applySerno 进件流水
     */
    public void setApplySerno(String applySerno) {
        this.applySerno = applySerno == null ? null : applySerno.trim();
    }

    /**
     * 获取产品类型 CH:现金代,WK:无卡
     *
     * @return PRODUCT_TYPE - 产品类型 CH:现金代,WK:无卡
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 设置产品类型 CH:现金代,WK:无卡
     *
     * @param productType 产品类型 CH:现金代,WK:无卡
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * 获取外部资金方进件流水
     *
     * @return EXTERNAL_FUND_APPLY_SERNO - 外部资金方进件流水
     */
    public String getExternalFundApplySerno() {
        return externalFundApplySerno;
    }

    /**
     * 设置外部资金方进件流水
     *
     * @param externalFundApplySerno 外部资金方进件流水
     */
    public void setExternalFundApplySerno(String externalFundApplySerno) {
        this.externalFundApplySerno = externalFundApplySerno == null ? null : externalFundApplySerno.trim();
    }

    /**
     * 获取推送记录系统流水号FUND_SEND_RECORD表SYS_SERNO
     *
     * @return SEND_RECORD_SYS_SERNO - 推送记录系统流水号FUND_SEND_RECORD表SYS_SERNO
     */
    public String getSendRecordSysSerno() {
        return sendRecordSysSerno;
    }

    /**
     * 设置推送记录系统流水号FUND_SEND_RECORD表SYS_SERNO
     *
     * @param sendRecordSysSerno 推送记录系统流水号FUND_SEND_RECORD表SYS_SERNO
     */
    public void setSendRecordSysSerno(String sendRecordSysSerno) {
        this.sendRecordSysSerno = sendRecordSysSerno == null ? null : sendRecordSysSerno.trim();
    }

    /**
     * 获取资金方标志
     *
     * @return FUND_ID - 资金方标志
     */
    public String getFundId() {
        return fundId;
    }

    /**
     * 设置资金方标志
     *
     * @param fundId 资金方标志
     */
    public void setFundId(String fundId) {
        this.fundId = fundId == null ? null : fundId.trim();
    }

    /**
     * 获取资金方名称
     *
     * @return FUND_NAME - 资金方名称
     */
    public String getFundName() {
        return fundName;
    }

    /**
     * 设置资金方名称
     *
     * @param fundName 资金方名称
     */
    public void setFundName(String fundName) {
        this.fundName = fundName == null ? null : fundName.trim();
    }

    /**
     * 获取推送状态 S：推送成功，F：推送失败，N：待推送
     *
     * @return SEND_STATUS - 推送状态 S：推送成功，F：推送失败，N：待推送
     */
    public String getSendStatus() {
        return sendStatus;
    }

    /**
     * 设置推送状态 S：推送成功，F：推送失败，N：待推送
     *
     * @param sendStatus 推送状态 S：推送成功，F：推送失败，N：待推送
     */
    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }

    /**
     * 获取返回码
     *
     * @return SEND_TIME - 返回码
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置返回码
     *
     * @param sendTime 返回码
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取实际贷款金额 贴息倒算订单 实贷本金不一致
     *
     * @return REAL_LOAN_AMOUNT - 实际贷款金额 贴息倒算订单 实贷本金不一致
     */
    public BigDecimal getRealLoanAmount() {
        return realLoanAmount;
    }

    /**
     * 设置实际贷款金额 贴息倒算订单 实贷本金不一致
     *
     * @param realLoanAmount 实际贷款金额 贴息倒算订单 实贷本金不一致
     */
    public void setRealLoanAmount(BigDecimal realLoanAmount) {
        this.realLoanAmount = realLoanAmount;
    }

    /**
     * 获取用户实际付息比例
     *
     * @return REAL_PERCENT_USER - 用户实际付息比例
     */
    public BigDecimal getRealPercentUser() {
        return realPercentUser;
    }

    /**
     * 设置用户实际付息比例
     *
     * @param realPercentUser 用户实际付息比例
     */
    public void setRealPercentUser(BigDecimal realPercentUser) {
        this.realPercentUser = realPercentUser;
    }

    /**
     * 获取即科分润比例
     *
     * @return SPLIT_RATE - 即科分润比例
     */
    public BigDecimal getSplitRate() {
        return splitRate;
    }

    /**
     * 设置即科分润比例
     *
     * @param splitRate 即科分润比例
     */
    public void setSplitRate(BigDecimal splitRate) {
        this.splitRate = splitRate;
    }

    /**
     * 获取资金方产品类型 WK001：无卡默认产品 WK002：无卡贴息产品 CASH001：现金贷默认产品 默认值：WK001
     *
     * @return FUND_PRODUCT_TYPE - 资金方产品类型 WK001：无卡默认产品 WK002：无卡贴息产品 CASH001：现金贷默认产品 默认值：WK001
     */
    public String getFundProductType() {
        return fundProductType;
    }

    /**
     * 设置资金方产品类型 WK001：无卡默认产品 WK002：无卡贴息产品 CASH001：现金贷默认产品 默认值：WK001
     *
     * @param fundProductType 资金方产品类型 WK001：无卡默认产品 WK002：无卡贴息产品 CASH001：现金贷默认产品 默认值：WK001
     */
    public void setFundProductType(String fundProductType) {
        this.fundProductType = fundProductType == null ? null : fundProductType.trim();
    }

    /**
     * 获取资金方返回码
     *
     * @return FUND_RSP_CODE - 资金方返回码
     */
    public String getFundRspCode() {
        return fundRspCode;
    }

    /**
     * 设置资金方返回码
     *
     * @param fundRspCode 资金方返回码
     */
    public void setFundRspCode(String fundRspCode) {
        this.fundRspCode = fundRspCode == null ? null : fundRspCode.trim();
    }

    /**
     * 获取资金方返回信息
     *
     * @return FUND_RSP_MSG - 资金方返回信息
     */
    public String getFundRspMsg() {
        return fundRspMsg;
    }

    /**
     * 设置资金方返回信息
     *
     * @param fundRspMsg 资金方返回信息
     */
    public void setFundRspMsg(String fundRspMsg) {
        this.fundRspMsg = fundRspMsg == null ? null : fundRspMsg.trim();
    }

    /**
     * 获取创建者
     *
     * @return CREATE_USER - 创建者
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建者
     *
     * @param createUser 创建者
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return UPDATE_USER - 更新者
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新者
     *
     * @param updateUser 更新者
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysSerno=").append(sysSerno);
        sb.append(", appId=").append(appId);
        sb.append(", applySerno=").append(applySerno);
        sb.append(", productType=").append(productType);
        sb.append(", externalFundApplySerno=").append(externalFundApplySerno);
        sb.append(", sendRecordSysSerno=").append(sendRecordSysSerno);
        sb.append(", fundId=").append(fundId);
        sb.append(", fundName=").append(fundName);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", realLoanAmount=").append(realLoanAmount);
        sb.append(", realPercentUser=").append(realPercentUser);
        sb.append(", splitRate=").append(splitRate);
        sb.append(", fundProductType=").append(fundProductType);
        sb.append(", fundRspCode=").append(fundRspCode);
        sb.append(", fundRspMsg=").append(fundRspMsg);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}