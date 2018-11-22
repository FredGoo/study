package gyqw.xiaobaitu.graph.model;

import java.io.Serializable;

/**
 * @author fred
 * 2018-11-22 10:11 AM
 */
public class GraphNodeModel implements Serializable {
    private String code;
    private String text;
    private String parentCode;
    private String state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GraphNodeModel{" +
                "code='" + code + '\'' +
                ", text='" + text + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
