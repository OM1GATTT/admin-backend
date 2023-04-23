package top.om1ga.rbac.service;


import top.om1ga.common.utils.PageResult;
import top.om1ga.mybatis.service.BaseService;
import top.om1ga.rbac.entity.SysLogLoginEntity;
import top.om1ga.rbac.query.SysLogLoginQuery;
import top.om1ga.rbac.vo.SysLogLoginVO;

public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {

    /**
     * 按条件分页查询
     * @param query
     * @return
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     * @param username  用户名
     * @param status    登录状态
     * @param operation 操作信息
     */
    void save(String username,Integer status,Integer operation);
}
