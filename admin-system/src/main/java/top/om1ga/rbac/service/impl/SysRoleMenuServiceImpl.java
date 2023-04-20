package top.om1ga.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.om1ga.security.config.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.dao.SysRoleMenuDao;
import top.om1ga.rbac.entity.SysRoleMenuEntity;
import top.om1ga.rbac.service.SysRoleMenuService;


/**
 * 角色与菜单对应服务
 *
 * @author mqxu
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {


}