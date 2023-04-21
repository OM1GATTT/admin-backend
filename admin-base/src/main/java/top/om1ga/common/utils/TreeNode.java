package top.om1ga.common.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月21日 10:27
 * @Description:
 * @since: 1.0
 */
@Data
public class TreeNode<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Schema(description = "id")
    private Long id;
    /**
     * 上级ID
     */
    @Schema(description = "上级ID")
    @NotNull(message = "上级ID不能为空")
    private Long pid;
    /**
     * 子节点列表
     */
    private List<T> children = new ArrayList<>();
}
