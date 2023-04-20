package top.om1ga.rbac.service.impl;


import org.springframework.stereotype.Service;
import top.om1ga.security.config.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.dao.SysUserRoleDao;
import top.om1ga.rbac.entity.SysUserRoleEntity;
import top.om1ga.rbac.service.SysUserRoleService;

/**
 * 用户角色关系服务
 *
 * @author mqxu
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}