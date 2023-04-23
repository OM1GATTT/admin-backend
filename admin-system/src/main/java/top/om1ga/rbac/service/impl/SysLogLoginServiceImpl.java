package top.om1ga.rbac.service.impl;

import ch.qos.logback.classic.spi.STEUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import top.om1ga.common.query.Query;
import top.om1ga.common.utils.PageResult;
import top.om1ga.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.rbac.convert.SysLogLoginConvert;
import top.om1ga.rbac.dao.SysLogLoginDao;
import top.om1ga.rbac.entity.SysLogLoginEntity;
import top.om1ga.rbac.query.SysLogLoginQuery;
import top.om1ga.rbac.service.SysLogLoginService;
import top.om1ga.rbac.vo.SysLogLoginVO;

import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月23日 13:56
 * @Description:
 * @since: 1.0
 */
@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

    @Override
    public PageResult<SysLogLoginVO> page(SysLogLoginQuery query) {
        IPage<SysLogLoginEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        List<SysLogLoginEntity> list = page.getRecords();
        List<SysLogLoginVO> resList = SysLogLoginConvert.INSTANCE.convertList(list);
        long count = page.getTotal();

        return new PageResult<>(resList,count);
    }

    private LambdaQueryWrapper<SysLogLoginEntity> getWrapper(SysLogLoginQuery query){
        LambdaQueryWrapper<SysLogLoginEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StrUtil.isNotBlank(query.getUsername()),SysLogLoginEntity::getUsername,query.getUsername());
        wrapper.like(StrUtil.isNotBlank(query.getAddress()),SysLogLoginEntity::getAddress,query.getAddress());
        wrapper.like(query.getStatus() != null,SysLogLoginEntity::getStatus,query.getStatus());
        wrapper.orderByDesc(SysLogLoginEntity::getId);
        return wrapper;
    }

    @Override
    public void save(String username, Integer status, Integer operation) {
        SysLogLoginEntity entity = new SysLogLoginEntity();
        entity.setUsername(username);
//        TODO:后续换成工具类获取真实ID、地址
        entity.setAddress("127.0.0.1");
        entity.setAddress("南京");
        entity.setStatus(status);
        entity.setOperation(operation);
    }
}
