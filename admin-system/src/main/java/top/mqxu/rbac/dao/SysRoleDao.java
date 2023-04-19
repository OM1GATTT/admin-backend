package top.mqxu.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.mqxu.mybatis.dao.BaseDao;
import top.mqxu.rbac.entity.SysRoleEntity;

/**
 * 角色管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
