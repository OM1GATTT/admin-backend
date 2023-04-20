package top.om1ga.service;

import top.om1ga.common.utils.PageResult;
import top.om1ga.entity.NoticeEntity;
import top.om1ga.security.config.mybatis.service.BaseService;
import top.om1ga.query.NoticeQuery;
import top.om1ga.vo.NoticeVO;

public interface NoticeService extends BaseService<NoticeEntity> {
    PageResult<NoticeVO> page(NoticeQuery query);
}
