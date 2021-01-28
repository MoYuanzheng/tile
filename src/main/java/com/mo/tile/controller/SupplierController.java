package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Supplier;
import com.mo.tile.service.impl.SupplierServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Supplier)表控制层
 *
 * @author mo
 * @since 2021-01-23 15:26:32
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {
    /**
     * 服务对象
     */
    @Resource
    private SupplierServiceImpl supplierService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Supplier selectOne(String id) {
        return supplierService.getById(id);
    }

    /**
     * 分 页 查 询
     */
    @GetMapping("table")
    public Page<Supplier> page(@RequestParam("pages") Integer pages) {
        return supplierService.selectPage(pages);
    }
}