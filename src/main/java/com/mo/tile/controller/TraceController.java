package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Trace;
import com.mo.tile.service.impl.TraceServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 追溯(Trace)表控制层
 *
 * @author MoYz
 * @since 2021-03-13 17:07:34
 */
@Api(tags = "追溯相关")
@RestController
@RequestMapping("trace")
public class TraceController {
    /**
     * 服务对象
     */
    @Resource
    private TraceServiceImpl traceService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键-对应商品追溯码") String id,
            @RequestParam("productId") @ApiParam("商品ID") String productId,
            @RequestParam("operationPerson") @ApiParam("操作员") String operationPerson,
            @RequestParam("content") @ApiParam("内容") String content,
            @RequestParam("type") @ApiParam("1物流，2装箱，3原材料") String type,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return traceService.add(new Trace(
                id,
                productId,
                operationPerson,
                content,
                type,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("登录账号") String id
    ) {
        return traceService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键-对应商品追溯码") String id,
            @RequestParam("productId") @ApiParam("商品ID") String productId,
            @RequestParam("operationPerson") @ApiParam("操作员") String operationPerson,

            @RequestParam("content") @ApiParam("内容") String content,
            @RequestParam("type") @ApiParam("物流或者分销") String type,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return traceService.update(new Trace(
                id,
                productId,
                operationPerson,
                content,
                type,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Trace> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return traceService.query(pages, key);
    }
}