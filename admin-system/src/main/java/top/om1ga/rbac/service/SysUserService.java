package top.om1ga.rbac.service;


import top.om1ga.mybatis.service.BaseService;
import top.om1ga.rbac.entity.SysUserEntity;

/**
 * 用户管理
 *
 * @author mqxu
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

}
