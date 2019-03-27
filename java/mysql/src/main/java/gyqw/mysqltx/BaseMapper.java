package gyqw.mysqltx;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author fred
 * 2019-03-27 4:21 PM
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
}
