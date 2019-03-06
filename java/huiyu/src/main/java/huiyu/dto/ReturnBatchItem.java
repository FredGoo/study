package huiyu.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fred
 * 2019-03-06 1:57 PM
 */
public class ReturnBatchItem implements Serializable {
    private String callstatus;
    private String talktime;
    private String orderNo;
    private String phone;
    private String uuid;
    private String intent;
    private Date calltime;

    public String getCallstatus() {
        return callstatus;
    }

    public void setCallstatus(String callstatus) {
        this.callstatus = callstatus;
    }

    public String getTalktime() {
        return talktime;
    }

    public void setTalktime(String talktime) {
        this.talktime = talktime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    @Override
    public String toString() {
        return "ReturnBatchItem{" +
                "callstatus='" + callstatus + '\'' +
                ", talktime='" + talktime + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", phone='" + phone + '\'' +
                ", uuid='" + uuid + '\'' +
                ", intent='" + intent + '\'' +
                ", calltime=" + calltime +
                '}';
    }
}
