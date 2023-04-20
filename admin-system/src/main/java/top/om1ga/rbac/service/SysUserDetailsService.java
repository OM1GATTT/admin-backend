package top.om1ga.rbac.service;


import org.springframework.security.core.userdetails.UserDetails;
import top.om1ga.rbac.entity.SysUserEntity;

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
