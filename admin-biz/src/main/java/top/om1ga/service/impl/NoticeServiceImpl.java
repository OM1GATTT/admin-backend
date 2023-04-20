package top.om1ga.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.om1ga.common.utils.PageResult;
import top.om1ga.convert.NoticeConvert;
import top.om1ga.dao.NoticeDao;
import top.om1ga.entity.NoticeEntity;
import top.om1ga.security.config.mybatis.service.impl.BaseServiceImpl;
import top.om1ga.query.NoticeQuery;
import top.om1ga.service.NoticeService;
import top.om1ga.vo.NoticeVO;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:37
 * @Description:
 * @since: 1.0
 */
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query),getWrapper(query));
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private Wrapper<NoticeEntity> getWrapper(NoticeQuery query){
        LambdaQueryWrapper<NoticeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()),NoticeEntity::getTitle,query.getTitle());
        return wrapper;
    }
}
