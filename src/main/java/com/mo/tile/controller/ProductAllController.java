package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.ProductAll;
import com.mo.tile.service.impl.ProductAllServiceImpl;
import com.mo.tile.util.GeneralFunctions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 所有商品(ProductAll)表控制层
 *
 * @author MoYz
 * @since 2021-03-14 14:15:34
 */
@Api(tags = "所有商品相关")
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
            @RequestParam("type") @ApiParam("产品类别") Integer type,
            @RequestParam("batch") @ApiParam("批次") String batch,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return productAllService.add(new ProductAll(
                GeneralFunctions.getRandomId(),
                type,
                batch,
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
            @RequestParam("type") @ApiParam("产品类别") Integer type,
            @RequestParam("batch") @ApiParam("批次") String batch,
            @RequestParam("inspectionPerson") @ApiParam("质检员") String inspectionPerson,
            @RequestParam("manufactureDate") @ApiParam("生产日期") String manufactureDate,
            @RequestParam("inspectionDate") @ApiParam("质检日期") String inspectionDate,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return productAllService.update(new ProductAll(
                id,
                type,
                batch,
                manufactureDate,
                inspectionDate,
                inspectionPerson,
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