package top.om1ga.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.om1ga.common.cache.RedisCache;
import top.om1ga.common.cache.RedisKeys;
import top.om1ga.rbac.service.SysCaptchaService;
import top.om1ga.rbac.vo.SysCaptchaVO;

import java.util.UUID;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 18:26
 * @Description:
 * @since: 1.0
 */
@Service
@AllArgsConstructor
public class SysCaptchaServiceImpl implements SysCaptchaService {

    private final RedisCache redisCache;

    @Override
    public SysCaptchaVO generate() {
//        生成验证码key
        String key = UUID.randomUUID().toString();
//        生成验证码
        SpecCaptcha captcha = new SpecCaptcha(150,40);
        captcha.setLen(5);
        captcha.setCharType(Captcha.TYPE_DEFAULT);
        String image = captcha.toBase64();

//        保存到缓存
        String redisKey = RedisKeys.getCaptchaKey(key);
        redisCache.set(redisKey,captcha.text());

//        封装返回数据
        SysCaptchaVO captchaVO = new SysCaptchaVO();
        captchaVO.setKey(key);
        captchaVO.setImage(image);

        return captchaVO;
    }

    @Override
    public boolean validate(String key, String code) {
        if(StrUtil.isBlank(key)||StrUtil.isBlank(code)){
            return false;
        }

//        获取验证码
        String captcha = getCache(key);

//        验证成功
        return code.equalsIgnoreCase(captcha);
    }

    private String getCache(String key){
        key = RedisKeys.getCaptchaKey(key);
        String captcha = (String) redisCache.get(key);
//        删除验证码
        if (captcha!=null){
            redisCache.delete(key);
        }

        return captcha;
    }
}
