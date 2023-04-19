package top.mqxu.rbac.service.impl;


import org.springframework.stereotype.Service;
import top.mqxu.mybatis.service.impl.BaseServiceImpl;
import top.mqxu.rbac.dao.SysUserRoleDao;
import top.mqxu.rbac.entity.SysUserRoleEntity;
import top.mqxu.rbac.service.SysUserRoleService;

/**
 * 用户角色关系服务
 *
 * @author mqxu
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}