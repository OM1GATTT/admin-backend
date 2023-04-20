package top.om1ga.system.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.om1ga.rbac.convert.SysUserConvert;
import top.om1ga.rbac.entity.SysUserEntity;
import top.om1ga.rbac.enums.UserStatusEnum;
import top.om1ga.rbac.service.SysUserDetailsService;
import top.om1ga.security.user.UserDetail;

import java.util.HashSet;
import java.util.Set;


/**
 * 获取用户 UserDetails 信息服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {

    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        Set<String> authoritySet = new HashSet<>();
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }

}
