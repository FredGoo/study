package gyqw.xiaobaitu.huiyu.dto;

import java.util.List;

/**
 * 计划明细
 * by kevin.yao
 */
public class BatchPlan {

    //private String batchno;
    //private int is_call;
    //账号
    private Integer accountid;
    //话术模板
    private String wordstemplateid;
    //机器人
    private String robotid;
    //private String calldate;
    //呼叫开始时间
    private String workstarttime;
    //呼叫结束时间
    private String workendtime;
    //呼叫明细
    private List<BatchDetail> details;

//	public String getBatchno() {
//		return batchno;
//	}
//
//	public void setBatchno(String batchno) {
//		this.batchno = batchno;
//	}

//	public int getIs_call() {
//		return is_call;
//	}
//
//	public void setIs_call(int is_call) {
//		this.is_call = is_call;
//	}

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getWordstemplateid() {
        return wordstemplateid;
    }

    public void setWordstemplateid(String wordstemplateid) {
        this.wordstemplateid = wordstemplateid;
    }

    public String getRobotid() {
        return robotid;
    }

    public void setRobotid(String robotid) {
        this.robotid = robotid;
    }

//	public String getCalldate() {
//		return calldate;
//	}
//
//	public void setCalldate(String calldate) {
//		this.calldate = calldate;
//	}

    public String getWorkstarttime() {
        return workstarttime;
    }

    public void setWorkstarttime(String workstarttime) {
        this.workstarttime = workstarttime;
    }

    public String getWorkendtime() {
        return workendtime;
    }

    public void setWorkendtime(String workendtime) {
        this.workendtime = workendtime;
    }

    public List<BatchDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BatchDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "BatchPlan{" +
                "accountid=" + accountid +
                ", wordstemplateid='" + wordstemplateid + '\'' +
                ", robotid='" + robotid + '\'' +
                ", workstarttime='" + workstarttime + '\'' +
                ", workendtime='" + workendtime + '\'' +
                ", details=" + details +
                '}';
    }

}