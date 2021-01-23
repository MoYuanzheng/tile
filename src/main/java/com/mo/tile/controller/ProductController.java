package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Product;
import com.mo.tile.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoYz
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Resource
    ProductServiceImpl productService;

    /**
     * 拿 到 所 有 数 据
     */
    @ResponseBody
    @GetMapping("data")
    public List<Product> getAll() {
        return productService.list();
    }

    /**
     * 返 回 一 条 记 录
     */
    @ResponseBody
    @GetMapping("selectOne")
    public Product getById(@RequestParam("id") Integer id) {
        return productService.getById(id);
    }


    /**
     * 删 除
     */
    @ResponseBody
    @DeleteMapping("delOne")
    public Boolean delById(@RequestParam("id") String id) {
        return productService.removeById(id);
    }


    /**
     * 分 页 查 询
     */
    @ResponseBody
    @GetMapping("table")
    public Page<Product> page(@RequestParam("pages") Integer pages) {
        return productService.selectPage(pages);
    }
}