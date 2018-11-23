package gyqw.xiaobaitu.graph.model;

import java.io.Serializable;

/**
 * @author fred
 * 2018-11-22 10:11 AM
 */
public class GraphNodeModel implements Serializable {
    private Long id;
    private String code;
    private String text;
    private String parentCode;
    private String parentText;
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getParentText() {
        return parentText;
    }

    public void setParentText(String parentText) {
        this.parentText = parentText;
    }

    @Override
    public String toString() {
        return "GraphNodeModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", text='" + text + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", parentText='" + parentText + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
