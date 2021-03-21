package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Batch;
import com.mo.tile.service.impl.BatchServiceImpl;
import com.mo.tile.util.GeneralFunctions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单批次表(Batch)表控制层
 *
 * @author MoYz
 * @since 2021-03-09 22:43:18
 */
@Api(tags = "订单批次表相关")
@RestController
@RequestMapping("batch")
public class BatchController {
    /**
     * 服务对象
     */
    @Resource
    private BatchServiceImpl batchService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("operator") @ApiParam("创建人员工号") String operator,
            @RequestParam("productType") @ApiParam("产品型号") Integer productType,
            @RequestParam("total") @ApiParam("订单总数") Integer total,
            @RequestParam("material") @ApiParam("材料代号") String material,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return batchService.add(new Batch(
                GeneralFunctions.getRandomId(),
                operator,
                productType,
                total,
                remark
        ), material);
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("订单号") String id
    ) {
        return batchService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("operator") @ApiParam("创建人员工号") String operator,
            @RequestParam("completeTime") @ApiParam("订单完成时间") String completeTime,
            @RequestParam("productType") @ApiParam("产品型号") Integer productType,
            @RequestParam("total") @ApiParam("订单总数") Integer total,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return batchService.update(new Batch(
                id,
                operator,
                productType,
                total,
                completeTime,
                remark
        ));
    }

    @ApiOperation("更新订单完成时间")
    @PutMapping("updateCompleteTime")
    public Boolean updateCompleteTime(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("completeTime") @ApiParam("订单完成时间") String completeTime
    ) {
        return batchService.updateCompleteTime(id, completeTime);
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Batch> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return batchService.query(pages, key);
    }
}