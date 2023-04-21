package top.om1ga.dao;

import org.apache.ibatis.annotations.Mapper;
import top.om1ga.entity.NoticeEntity;
import top.om1ga.mybatis.dao.BaseDao;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:23
 * @Description:
 * @since: 1.0
 */
@Mapper
public interface NoticeDao extends BaseDao<NoticeEntity> {
}
