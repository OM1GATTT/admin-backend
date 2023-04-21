package top.om1ga.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.om1ga.mybatis.entity.BaseEntity;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:21
 * @Description: Notice
 * @since: 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_notice")
public class NoticeEntity extends BaseEntity {
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
}
