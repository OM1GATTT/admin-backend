package top.om1ga.rbac.event;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import top.om1ga.common.constant.Constant;
import top.om1ga.rbac.enums.LoginOperationEnum;
import top.om1ga.rbac.service.SysLogLoginService;
import top.om1ga.security.user.UserDetail;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月23日 14:30
 * @Description:
 * @since: 1.0
 */
@Component
@AllArgsConstructor
public class AuthenticationEvents {
    private final SysLogLoginService sysLogLoginService;

    /**
     * 认证成功事件处理
     * @param event 事件对象
     */
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event){
//        获取用户信息
        UserDetail user = (UserDetail) event.getAuthentication().getPrincipal();
//        保存登录成功日志
        sysLogLoginService.save(user.getUsername(), Constant.SUCCESS, LoginOperationEnum.LOGIN_SUCCESS.getValue());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event){
//        获取用户名
        String username = (String) event.getAuthentication().getPrincipal();
//        保存登录失败日志
        sysLogLoginService.save(username,Constant.FAIL,LoginOperationEnum.ACCOUNT_FAIL.getValue());
    }
}
