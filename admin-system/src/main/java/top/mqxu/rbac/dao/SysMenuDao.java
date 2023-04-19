package top.mqxu.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.mqxu.mybatis.dao.BaseDao;
import top.mqxu.rbac.entity.SysMenuEntity;


/**
 * 菜单管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {


}
