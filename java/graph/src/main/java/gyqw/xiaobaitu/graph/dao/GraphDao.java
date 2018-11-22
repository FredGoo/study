package gyqw.xiaobaitu.graph.dao;

import gyqw.xiaobaitu.graph.model.GraphNodeModel;

/**
 * @author fred
 * 2018-11-22 5:31 PM
 */
public interface GraphDao {

    void init();

    void mutate(GraphNodeModel graphNodeModel);
}
