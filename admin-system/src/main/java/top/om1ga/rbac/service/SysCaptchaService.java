package top.om1ga.rbac.service;

import top.om1ga.rbac.vo.SysCaptchaVO;

public interface SysCaptchaService {
    /**
     * 生成验证码
     */
    SysCaptchaVO generate();

    /**
     * 验证码校验
     *
     * @param key
     * @param code
     * @return true 成功 false 失败
     */
    boolean validate(String key,String code);
}
