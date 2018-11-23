package gyqw.xiaobaitu.graph.domain.neo4j;


import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author fred
 * 2018-11-23 10:01 AM
 */
@NodeEntity
public class Auth {

    @Id
    private String code;
    private String text;
    @Relationship(type = "CHILD_OF")
    private Auth parentAuth;

    public Auth(String code, String text, Auth parentAuth) {
        this.code = code;
        this.text = text;
        this.parentAuth = parentAuth;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public Auth getParentAuth() {
        return parentAuth;
    }

    @Override
    public String toString() {
        return "Auth{" +
                ", code='" + code + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
