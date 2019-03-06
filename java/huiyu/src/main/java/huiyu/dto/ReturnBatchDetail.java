package huiyu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author fred
 * 2019-03-06 2:20 PM
 */
public class ReturnBatchDetail implements Serializable {
    private int count;
    private List<ReturnBatchDetailItem> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ReturnBatchDetailItem> getList() {
        return list;
    }

    public void setList(List<ReturnBatchDetailItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ReturnBatchDetail{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }
}
