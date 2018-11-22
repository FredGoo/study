package gyqw.xiaobaitu.graph.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author fred
 * 2018-11-21 5:37 PM
 */
public class NodeModel implements Serializable {
    private String id;
    private String text;
    private String state;
    private List<NodeModel> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<NodeModel> getChildren() {
        return children;
    }

    public void setChildren(List<NodeModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "NodeModel{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", state='" + state + '\'' +
                ", children=" + children +
                '}';
    }
}
