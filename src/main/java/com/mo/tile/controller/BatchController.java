package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Batch;
import com.mo.tile.service.impl.BatchServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 订单表(Batch)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 15:25:33
 */
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
            @RequestParam("id") String id,
            @RequestParam("orderTime") Date orderTime,
            @RequestParam("completeTime") Date completeTime,
            @RequestParam("productType") Integer productType,
            @RequestParam("total") Integer total,
            @RequestParam("remark") String remark
    ) {
        return batchService.update(new Batch(
                id,
                orderTime,
                completeTime,
                productType,
                total,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("账号") String id
    ) {
        return batchService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") String id,
            @RequestParam("orderTime") Date orderTime,
            @RequestParam("completeTime") Date completeTime,
            @RequestParam("productType") Integer productType,
            @RequestParam("total") Integer total,
            @RequestParam("remark") String remark
    ) {
        return batchService.update(new Batch(
                id,
                orderTime,
                completeTime,
                productType,
                total,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Batch> query(
            @RequestParam("pages") Integer pages,
            @RequestParam("key") String key
    ) {
        return batchService.query(pages, key);
    }
}