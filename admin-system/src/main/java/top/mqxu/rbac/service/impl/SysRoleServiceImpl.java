package top.mqxu.rbac.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.mqxu.mybatis.service.impl.BaseServiceImpl;
import top.mqxu.rbac.dao.SysRoleDao;
import top.mqxu.rbac.entity.SysRoleEntity;
import top.mqxu.rbac.service.SysRoleService;

/**
 * 系统角色服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}