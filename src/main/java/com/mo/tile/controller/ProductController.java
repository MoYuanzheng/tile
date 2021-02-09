package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Product;
import com.mo.tile.service.impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author MoYz
 */
@Controller
@ResponseBody
@RequestMapping("product")
@Api(tags = "产品相关")
public class ProductController {

    @Resource
    ProductServiceImpl productService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") String id,
            @RequestParam("type") Integer type,
            @RequestParam("batch") String batch,
            @RequestParam("price") String price,
            @RequestParam("qrCode") String qrCode,
            @RequestParam("remark") String remark
    ) {
        return productService.add(new Product(
                id,
                type,
                batch,
                price,
                qrCode,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("账号") String id) {
        return productService.del(id);
    }

    @ApiOperation("修 改")
    @PostMapping("update")
    public Boolean update(
            @RequestParam("id") String id,
            @RequestParam("type") Integer type,
            @RequestParam("batch") String batch,
            @RequestParam("price") String price,
            @RequestParam("qrCode") String qrCode,
            @RequestParam("remark") String remark
    ) {
        return productService.add(new Product(
                id,
                type,
                batch,
                price,
                qrCode,
                remark
        ));
    }

    @ApiOperation("分 页 查 询")
    @GetMapping("query")
    public Page<Product> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键字") String key
    ) {
        return productService.query(pages, key);
    }

}