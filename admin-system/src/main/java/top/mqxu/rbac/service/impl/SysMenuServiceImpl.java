package top.mqxu.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.mqxu.mybatis.service.impl.BaseServiceImpl;
import top.mqxu.rbac.dao.SysMenuDao;
import top.mqxu.rbac.entity.SysMenuEntity;
import top.mqxu.rbac.service.SysMenuService;


/**
 * 菜单管理服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}