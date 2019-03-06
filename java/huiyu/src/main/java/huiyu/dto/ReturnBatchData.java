package huiyu.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author fred
 * 2019-03-06 2:02 PM
 */
public class ReturnBatchData implements Serializable {
    private int count;
    private List<ReturnBatchItem> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ReturnBatchItem> getList() {
        return list;
    }

    public void setList(List<ReturnBatchItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ReturnBatchData{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }
}
