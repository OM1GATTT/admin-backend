package top.om1ga.service;

import top.om1ga.common.utils.PageResult;
import top.om1ga.entity.NoticeEntity;
import top.om1ga.mybatis.service.BaseService;
import top.om1ga.query.NoticeQuery;
import top.om1ga.vo.NoticeVO;

import java.util.List;

public interface NoticeService extends BaseService<NoticeEntity> {
    PageResult<NoticeVO> page(NoticeQuery query);

    List<NoticeVO> getList();

    void save(NoticeVO vo);
    void update(NoticeVO vo);

    void delete(Long id);
}
