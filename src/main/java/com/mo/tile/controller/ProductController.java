package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Product;
import com.mo.tile.service.impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 产品(Product)表控制层
 *
 * @author MoYz
 * @since 2021-02-17 18:21:42
 */
@Api(tags = "产品相关")
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductServiceImpl productService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("type") @ApiParam("产品型号") Integer type,
            @RequestParam("cnName") @ApiParam("中文名称") String cnName,
            @RequestParam("price") @ApiParam("单价") Object price,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return productService.update(new Product(
                id,
                type,
                cnName,
                price,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("登录账号") String id
    ) {
        return productService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("type") @ApiParam("产品型号") Integer type,
            @RequestParam("cnName") @ApiParam("中文名称") String cnName,
            @RequestParam("price") @ApiParam("单价") Object price,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return productService.update(new Product(
                id,
                type,
                cnName,
                price,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Product> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return productService.query(pages, key);
    }
}