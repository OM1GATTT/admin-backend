package top.mqxu.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.mqxu.mybatis.dao.BaseDao;
import top.mqxu.rbac.entity.SysRoleMenuEntity;


/**
 * 角色与菜单对应关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
}
