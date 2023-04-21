package top.om1ga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.om1ga.common.utils.PageResult;
import top.om1ga.common.utils.Result;
import top.om1ga.convert.NoticeConvert;
import top.om1ga.entity.NoticeEntity;
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
@Slf4j
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("page")
    @Operation(summary = "通知分页")
    @PreAuthorize("hasAuthority('sys:notice:page')")
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

    @GetMapping("{id}")
    @Operation(summary = "通知信息")
    @PreAuthorize("hasAuthority('sys:notice:info')")
    public Result<NoticeVO> get(@PathVariable("id")Long id){
        NoticeEntity entity = noticeService.getById(id);
        return Result.ok(NoticeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增通知")
    @PreAuthorize("hasAuthority('sys:notice:save')")
    public Result<String> save (@RequestBody NoticeVO vo){
        noticeService.save(vo);
        return Result.ok();
    }


    @PutMapping
    @Operation(summary = "修改通知")
    @PreAuthorize("hasAuthority('sys:notice:update')")
    public Result<String> update (@RequestBody @Valid NoticeVO vo){
        log.info(vo.toString());
        noticeService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除通知")
    @PreAuthorize("hasAuthority('sys:notice:delete')")
    public Result<String> delete (@PathVariable("id")Long id){
        noticeService.delete(id);
        return Result.ok();
    }
}
