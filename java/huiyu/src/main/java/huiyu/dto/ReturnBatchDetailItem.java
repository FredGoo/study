package huiyu.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fred
 * 2019-03-06 2:20 PM
 */
public class ReturnBatchDetailItem implements Serializable {
    private String atext;
    private String btext;
    private int sort;
    private Date time;

    public String getAtext() {
        return atext;
    }

    public void setAtext(String atext) {
        this.atext = atext;
    }

    public String getBtext() {
        return btext;
    }

    public void setBtext(String btext) {
        this.btext = btext;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ReturnBatchDetailItem{" +
                "atext='" + atext + '\'' +
                ", btext='" + btext + '\'' +
                ", sort=" + sort +
                ", time=" + time +
                '}';
    }
}
