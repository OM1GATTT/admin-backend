package top.om1ga.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.om1ga.common.query.Query;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:33
 * @Description:
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query {

    @Schema(description = "通知标题")
    private String title;
}
