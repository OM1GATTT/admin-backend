package top.mqxu.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.mqxu.mybatis.dao.BaseDao;
import top.mqxu.rbac.entity.SysUserRoleEntity;


/**
 * 用户角色关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

}