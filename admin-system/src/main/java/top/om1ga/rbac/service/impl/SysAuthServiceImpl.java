package top.om1ga.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import top.om1ga.common.exception.ServerException;
import top.om1ga.rbac.service.SysAuthService;
import top.om1ga.rbac.service.SysCaptchaService;
import top.om1ga.rbac.service.SysMenuService;
import top.om1ga.rbac.vo.SysAccountLoginVO;
import top.om1ga.rbac.vo.SysTokenVO;
import top.om1ga.security.cache.TokenStoreCache;
import top.om1ga.security.user.UserDetail;
import top.om1ga.security.utils.TokenUtils;

import java.util.Set;


/**
 * 权限认证服务
 *
 * @author mqxu
 */
@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService {
    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;

    private final SysCaptchaService sysCaptchaService;

    private final SysMenuService menuService;
    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {
//        验证码校验
/*暂时不需要验证码，可以在这去掉*/
//        boolean flag = sysCaptchaService.validate(login.getKey(), login.getCaptcha());
//        if (!flag){
//            throw new ServerException("验证码错误");
//        }

        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();
        Set<String> authority = menuService.getUserAuthority(user);
        user.setAuthoritySet(authority);

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // 获取用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        // 删除用户
        tokenStoreCache.deleteUser(accessToken);
    }
}
