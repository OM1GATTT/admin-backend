package top.mqxu.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.mqxu.mybatis.entity.BaseEntity;
import top.mqxu.rbac.enums.UserStatusEnum;

/**
 * 系统用户表实体类
 *
 * @author mqxu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别   0：男   1：女   2：未知
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;
    /**
     * 状态  {@link UserStatusEnum}
     */
    private Integer status;
}
