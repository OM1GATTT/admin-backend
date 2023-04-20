package top.om1ga.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.dao.SysMenuDao;
import top.om1ga.rbac.entity.SysMenuEntity;
import top.om1ga.rbac.service.SysMenuService;


/**
 * 菜单管理服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}