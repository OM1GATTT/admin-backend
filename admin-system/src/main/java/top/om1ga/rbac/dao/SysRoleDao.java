package top.om1ga.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.om1ga.security.config.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysRoleEntity;

/**
 * 角色管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
