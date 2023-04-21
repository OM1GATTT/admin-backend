package top.om1ga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.om1ga.common.utils.PageResult;
import top.om1ga.common.utils.Result;
import top.om1ga.query.NoticeQuery;
import top.om1ga.service.NoticeService;
import top.om1ga.vo.NoticeVO;

import java.util.List;

/**
 * @author: OM1GA
 * @version: 1.0
 * @Date: 2023年04月20日 21:48
 * @Description:
 * @since: 1.0
 */
@RestController
@RequestMapping("notice")
@Tag(name="通知管理")
@AllArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("page")
    @Operation(summary = "通知分页")
//    @PreAuthorize("hasAuthority('sys:notice:page')")
    public Result<PageResult<NoticeVO>> page (@ParameterObject @Valid NoticeQuery query){
        PageResult<NoticeVO> page = noticeService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "通知列表")
    public Result<List<NoticeVO>> list(){
        List<NoticeVO> list = noticeService.getList();
        return Result.ok(list);
    }
}
