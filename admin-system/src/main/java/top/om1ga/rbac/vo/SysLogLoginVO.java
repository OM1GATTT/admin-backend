package top.om1ga.rbac.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月23日 13:42
 * @Description:
 * @since: 1.0
 */
@Data
@Schema(description = "登录日志")
public class SysLogLoginVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "登录IP")
    private String ip;

    @Schema(description = "登录地址")
    private String address;

    @Schema(description = "登录设备UA")
    private String userAgent;

    @Schema(description = "登录状态 0：失败  1：成功")
    private Integer status;

    @Schema(description = "操作信息 0：登录成功   1：退出成功  2：验证码错误  3：账号密码错误")
    private Integer operations;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
