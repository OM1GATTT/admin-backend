package top.mqxu.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.mqxu.mybatis.entity.BaseEntity;

/**
 * 角色表实体类
 *
 * @author mqxu
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
}
