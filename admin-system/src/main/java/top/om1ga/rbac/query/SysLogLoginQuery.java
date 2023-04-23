package top.om1ga.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.om1ga.common.query.Query;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月23日 13:50
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "登录日志查询参数")
public class SysLogLoginQuery extends Query {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "登录地点")
    private String address;

    @Schema(description = "登录状态 0：失败  1：成功")
    private Integer status;
}
