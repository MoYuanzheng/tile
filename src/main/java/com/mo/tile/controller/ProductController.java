package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Product;
import com.mo.tile.service.impl.ProductServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoYz
 */
@Controller
@RequestMapping("product")
@Api(tags = "产品相关")
public class ProductController {

    @Resource
    ProductServiceImpl productService;

    @ApiOperation("拿 到 所 有 产 品 数 据")
    @GetMapping("data")
    public List<Product> getAll() {
        return productService.list();
    }

    @ApiOperation("返 回 一 条 记 录")
    @GetMapping("selectOne")
    public Product getById(@RequestParam("id") @ApiParam("账号") Integer id) {
        return productService.getById(id);
    }

    @ApiOperation("删 除")
    @DeleteMapping("delOne")
    public Boolean delById(@RequestParam("id") @ApiParam("账号") String id) {
        return productService.removeById(id);
    }


    @ApiOperation("分 页 查 询")
    @GetMapping("table")
    public Page<Product> page(@RequestParam("pages") @ApiParam("页数") Integer pages) {
        return productService.selectPage(pages);
    }
}