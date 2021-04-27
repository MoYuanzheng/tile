package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.History;
import com.mo.tile.service.impl.HistoryServiceImpl;
import com.mo.tile.util.GeneralFunctions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (History)表控制层
 *
 * @author MoYz
 * @since 2021-04-27 17:38:52
 */
@Api(tags = "相关")
@RestController
@RequestMapping("history")
public class HistoryController {
    /**
     * 服务对象
     */
    @Resource
    private HistoryServiceImpl historyService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("userId") @ApiParam("用户ID") String userId,
            @RequestParam("productId") @ApiParam("产品ID") String productId,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return historyService.add(new History(
                GeneralFunctions.getRandomId(),
                userId,
                productId,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return historyService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("userId") @ApiParam("用户ID") String userId,
            @RequestParam("productId") @ApiParam("产品ID") String productId,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return historyService.update(new History(
                id,
                userId,
                productId,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<History> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return historyService.query(pages, key);
    }
}