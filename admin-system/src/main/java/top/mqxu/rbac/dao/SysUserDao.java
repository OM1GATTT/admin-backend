package top.mqxu.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.mqxu.mybatis.dao.BaseDao;
import top.mqxu.rbac.entity.SysUserEntity;

/**
 * 系统用户 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

	default SysUserEntity getByUsername(String username){
		return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
	}

}