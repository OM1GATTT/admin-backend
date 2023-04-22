package top.om1ga.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月22日 12:15
 * @Description:
 * @since: 1.0
 */
@Data
@Schema(description = "认证返回")
public class SysAuthVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private SysUserVO sysUserVO;

    private List<SysMenuVO> nav;

    private Set<String> authority;
}
