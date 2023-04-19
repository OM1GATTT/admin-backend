package top.mqxu.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.mqxu.mybatis.service.impl.BaseServiceImpl;
import top.mqxu.rbac.dao.SysUserDao;
import top.mqxu.rbac.entity.SysUserEntity;
import top.mqxu.rbac.service.SysUserService;

/**
 * 系统用户服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }
}
