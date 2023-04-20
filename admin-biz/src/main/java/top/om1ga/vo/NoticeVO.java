package top.om1ga.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.om1ga.common.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:25
 * @Description: NoticeVO
 * @since: 1.0
 */
@Data
@Schema(description = "通知")
public class NoticeVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long id;

    @Schema(description = "通知标题")
    @NotBlank(message = "通知标题不能为空")
    private String title;

    @Schema(description = "通知内容")
    @NotBlank(message = "通知内容不能为空")
    private String content;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;
}
