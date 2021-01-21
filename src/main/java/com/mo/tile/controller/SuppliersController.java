package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.bean.Suppliers;
import com.mo.tile.service.impl.SuppliersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Suppliers)表控制层
 *
 * @author mo
 * @since 2021-01-22 00:35:02
 */
@RestController
@RequestMapping("suppliers")
public class SuppliersController {
    /**
     * 服务对象
     */
    @Autowired
    private SuppliersServiceImpl suppliersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Suppliers selectOne(String id) {
        return suppliersService.getById(id);
    }

    /* *
     * 分 页 查 询
     */
    @ResponseBody
    @GetMapping("table")
    public Page<Suppliers> page(@RequestParam("pages") Integer pages) {
        return suppliersService.selectPage(pages);
    }
}