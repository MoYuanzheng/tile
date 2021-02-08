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
import java.util.List;
import java.util.Map;

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

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(@RequestParam("id") String id,
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

    @ApiOperation("拿 到 所 有 产 品 数 据")
    @GetMapping("query")
    public List<Map<String, Object>> query(@RequestParam("key") String key) {
        return productService.query(key);
    }
}