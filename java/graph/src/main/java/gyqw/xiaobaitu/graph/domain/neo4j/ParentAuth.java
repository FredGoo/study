package gyqw.xiaobaitu.graph.domain.neo4j;

import org.neo4j.ogm.annotation.*;

/**
 * @author fred
 * 2018-11-23 2:21 PM
 */
@RelationshipEntity(type = "CHILD_OF")
public class ParentAuth {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Auth parent;

    @EndNode
    private Auth child;

    public ParentAuth(Auth parent, Auth child) {
        this.parent = parent;
        this.child = child;
    }

    public Long getId() {
        return id;
    }

    public Auth getParent() {
        return parent;
    }

    public Auth getChild() {
        return child;
    }
}
