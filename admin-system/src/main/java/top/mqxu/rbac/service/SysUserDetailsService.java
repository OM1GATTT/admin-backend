package top.mqxu.rbac.service;


import org.springframework.security.core.userdetails.UserDetails;
import top.mqxu.rbac.entity.SysUserEntity;

/**
 * 用户信息服务
 * @author moqi
 */
public interface SysUserDetailsService {

    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
