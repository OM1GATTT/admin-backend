package top.mqxu.security.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.mqxu.common.cache.RedisCache;
import top.mqxu.security.user.UserDetail;
import top.mqxu.common.cache.RedisKeys;

/**
 * 登录用户的缓存操作
 *
 * @author mqxu
 */
@Component
@AllArgsConstructor
public class TokenStoreCache {

    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
