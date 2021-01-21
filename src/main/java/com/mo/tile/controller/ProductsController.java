package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.bean.Products;
import com.mo.tile.service.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductsController {

    @Autowired
    ProductsServiceImpl productsService;

    /*
     * 拿 到 所 有 数 据
     * */
    @ResponseBody
    @GetMapping("data")
    public List<Products> getAll() {
        return productsService.list();
    }

    /*
     * 返 回 一 条 记 录
     * */
    @ResponseBody
    @GetMapping("selectOne")
    public Products getById(@RequestParam("id") Integer id) {
        return productsService.getById(id);
    }


    /*
     * 删 除
     * */
    @ResponseBody
    @DeleteMapping("delOne")
    public Boolean delById(@RequestParam("id") Integer id) {
        return productsService.removeById(id);
    }


    /*
     * 分 页 查 询
     * */
    @ResponseBody
    @GetMapping("table")
    public Page<Products> page(@RequestParam("pages") Integer pages) {
        return productsService.selectPage(pages);
    }
}