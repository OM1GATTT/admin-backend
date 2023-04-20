package top.om1ga.rbac.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.dao.SysRoleDao;
import top.om1ga.rbac.entity.SysRoleEntity;
import top.om1ga.rbac.service.SysRoleService;

/**
 * 系统角色服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}