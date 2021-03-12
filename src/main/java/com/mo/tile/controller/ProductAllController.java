package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.ProductAll;
import com.mo.tile.service.impl.ProductAllServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (ProductAll)表控制层
 *
 * @author MoYz
 * @since 2021-03-09 22:42:17
 */
@Api(tags = "所有产品相关")
@RestController
@RequestMapping("productAll")
public class ProductAllController {
    /**
     * 服务对象
     */
    @Resource
    private ProductAllServiceImpl productAllService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("type") @ApiParam("产品类别") String type,
            @RequestParam("batch") @ApiParam("批次") String batch,
            @RequestParam("manufactureDate") @ApiParam("生产日期") Date manufactureDate,
            @RequestParam("inspectionDate") @ApiParam("质检日期") Date inspectionDate,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return productAllService.update(new ProductAll(
                id,
                type,
                batch,
                manufactureDate,
                inspectionDate,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("登录账号") String id
    ) {
        return productAllService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("type") @ApiParam("产品类别") String type,
            @RequestParam("batch") @ApiParam("批次") String batch,
            @RequestParam("manufactureDate") @ApiParam("生产日期") Date manufactureDate,
            @RequestParam("inspectionDate") @ApiParam("质检日期") Date inspectionDate,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return productAllService.update(new ProductAll(
                id,
                type,
                batch,
                manufactureDate,
                inspectionDate,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<ProductAll> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return productAllService.query(pages, key);
    }
}