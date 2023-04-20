package top.om1ga.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.om1ga.entity.NoticeEntity;
import top.om1ga.vo.NoticeVO;

import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:30
 * @Description: NoticeConvert
 * @since: 1.0
 */
@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    NoticeVO convert(NoticeEntity entity);

    NoticeEntity convert(NoticeVO vo);

    List<NoticeVO> convertList(List<NoticeEntity> list);
}
