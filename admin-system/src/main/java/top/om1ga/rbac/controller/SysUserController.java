package top.om1ga.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import top.om1ga.common.utils.Result;
import top.om1ga.rbac.convert.SysUserConvert;
import top.om1ga.rbac.service.SysMenuService;
import top.om1ga.rbac.service.SysUserService;
import top.om1ga.rbac.vo.SysAuthVO;
import top.om1ga.rbac.vo.SysUserPasswordVO;
import top.om1ga.rbac.vo.SysUserVO;
import top.om1ga.security.user.SecurityUser;
import top.om1ga.security.user.UserDetail;


/**
 * 用户管理接口
 *
 * @author mqxu
 */
@RestController
@RequestMapping("sys/user")
@AllArgsConstructor
@Tag(name = "用户管理")
public class SysUserController {
    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;

    private final SysMenuService sysMenuService;

    @PostMapping("info")
    @Operation(summary = "获取登录用户信息")
    public Result<SysAuthVO> info() {
        UserDetail userDetail = SecurityUser.getUser();

        SysUserVO user = SysUserConvert.INSTANCE.convert(userDetail);
        SysAuthVO vo = new SysAuthVO();

        vo.setSysUserVO(user);
        vo.setNav(sysMenuService.getUserMenuList(userDetail,0));
        vo.setAuthority(sysMenuService.getUserAuthority(userDetail));
        return Result.ok(vo);
    }

    @PostMapping("password")
    @Operation(summary = "修改密码")
    public Result<String> password(@RequestBody @Valid SysUserPasswordVO vo) {
        // 原密码不正确
        UserDetail user = SecurityUser.getUser();
        if (!passwordEncoder.matches(vo.getOldPassword(), user.getPassword())) {
            return Result.error("原密码不正确");
        }
        // 修改密码
        sysUserService.updatePassword(user.getId(), passwordEncoder.encode(vo.getNewPassword()));
        return Result.ok();
    }

}
