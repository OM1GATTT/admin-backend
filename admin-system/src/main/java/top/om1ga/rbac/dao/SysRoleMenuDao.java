package top.om1ga.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.om1ga.security.config.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysRoleMenuEntity;


/**
 * 角色与菜单对应关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
}
