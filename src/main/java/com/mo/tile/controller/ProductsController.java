package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.bean.Products;
import com.mo.tile.service.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    ProductsServiceImpl productsServiceImpl;

    /*
     * 拿 到 所 有 数 据
     * */
    @ResponseBody
    @GetMapping("/data")
    public List<Products> getAll() {
        return productsServiceImpl.list();
    }

    /*
     * 返 回 一 条 记 录
     * */
    @ResponseBody
    @GetMapping("/get")
    public Products getById(@RequestParam("id") Integer id) {
        return productsServiceImpl.getById(id);
    }


    /*
     * 删 除
     * */
    @ResponseBody
    @GetMapping("/del")
    public Boolean delById(@RequestParam("id") Integer id) {
        return productsServiceImpl.removeById(id);
    }


    /*
     * 分 页 查 询
     * */
    @ResponseBody
    @GetMapping("/table")
    public Page<Products> page(@RequestParam("pages") Integer pages) {
        return productsServiceImpl.selectPage(pages);
    }
}