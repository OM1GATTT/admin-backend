package top.mqxu.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import top.mqxu.common.exception.ServerException;
import top.mqxu.rbac.service.SysAuthService;
import top.mqxu.rbac.vo.SysAccountLoginVO;
import top.mqxu.rbac.vo.SysTokenVO;
import top.mqxu.security.cache.TokenStoreCache;
import top.mqxu.security.user.UserDetail;
import top.mqxu.security.utils.TokenUtils;


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

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {

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
