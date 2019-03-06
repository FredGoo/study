package huiyu.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fred
 * 2019-03-06 3:43 PM
 */
public class ExcelRow implements Serializable {
    private String intent;
    private String phone;
    private Date callTime;
    private String callStatus;
    private String callDuration;
    private String callContent;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public String getCallContent() {
        return callContent;
    }

    public void setCallContent(String callContent) {
        this.callContent = callContent;
    }

    @Override
    public String toString() {
        return "ExcelRow{" +
                "intent='" + intent + '\'' +
                ", phone='" + phone + '\'' +
                ", callTime=" + callTime +
                ", callStatus='" + callStatus + '\'' +
                ", callDuration='" + callDuration + '\'' +
                ", callContent='" + callContent + '\'' +
                '}';
    }
}
