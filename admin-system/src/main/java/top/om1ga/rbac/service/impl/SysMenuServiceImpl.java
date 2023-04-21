package top.om1ga.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.om1ga.common.constant.Constant;
import top.om1ga.common.utils.TreeUtils;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.convert.SysMenuConvert;
import top.om1ga.rbac.dao.SysMenuDao;
import top.om1ga.rbac.entity.SysMenuEntity;
import top.om1ga.rbac.enums.SuperAdminEnum;
import top.om1ga.rbac.service.SysMenuService;
import top.om1ga.rbac.vo.SysMenuVO;
import top.om1ga.security.user.UserDetail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 菜单管理服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
@Slf4j
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuVO> getMenuList(Integer type) {
        List<SysMenuEntity> menuList = baseMapper.getMenuList(type);
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList), Constant.ROOT);
    }

    @Override
    public List<SysMenuVO> getUserMenuList(UserDetail user, Integer type) {
        List<SysMenuEntity> menuList;
//        系统管理员，拥有最高权限
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            menuList = baseMapper.getMenuList(type);
            log.info(menuList.toString());
        } else {
            menuList = baseMapper.getUserMenuList(user.getId(), type);
            log.info(menuList.toString());
        }
        List<SysMenuVO> build = TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList));
        log.info(build.toString());
        return build;
    }

    @Override
    public Set<String> getUserAuthority(UserDetail user) {
        List<String> authorityList;
//        系统管理员
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
//            赋予所有权限
            authorityList = baseMapper.getAuthorityList();
        } else {
//            查询该用户的所有权限
            authorityList = baseMapper.getUserAuthorityList(user.getId());
        }

//        根据，分割字符串，得到list,去重去空，加入set
        Set<String> permsSet = new HashSet<>();
        for (String authority :
                authorityList) {
            if (StrUtil.isBlank(authority)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(authority.trim().split(",")));
        }
        return permsSet;
    }
}