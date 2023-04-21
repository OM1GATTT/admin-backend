package top.om1ga.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.om1ga.mybatis.dao.BaseDao;
import top.om1ga.rbac.entity.SysMenuEntity;

import java.util.List;


/**
 * 菜单管理 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

    /**
     * 查询所有菜单列表
     * @param type
     * @return
     */
    List<SysMenuEntity> getMenuList(@Param("type") Integer type);

    /**
     * 查询用户菜单列表
     * @param userId
     * @param type
     * @return
     */
    List<SysMenuEntity> getUserMenuList(@Param("userId")Long userId,@Param("type") Integer type);

    /**
     * 查询用户权限列表
     * @param userId
     * @return
     */
    List<String> getUserAuthorityList(@Param("userId")Long userId);

    /**
     * 查询所有权限列表
     * @return
     */
    List<String> getAuthorityList();
}
