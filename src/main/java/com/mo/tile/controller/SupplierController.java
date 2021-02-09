package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Supplier;
import com.mo.tile.service.impl.SupplierServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Supplier)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 15:25:34
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {
    /**
     * 服务对象
     */
    @Resource
    private SupplierServiceImpl supplierService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") String id,
            @RequestParam("material") String material,
            @RequestParam("fullName") String fullName,
            @RequestParam("header") String header,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("remark") String remark
    ) {
        return supplierService.update(new Supplier(
                id,
                material,
                fullName,
                header,
                phone,
                address,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("账号") String id
    ) {
        return supplierService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") String id,
            @RequestParam("material") String material,
            @RequestParam("fullName") String fullName,
            @RequestParam("header") String header,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("remark") String remark
    ) {
        return supplierService.update(new Supplier(
                id,
                material,
                fullName,
                header,
                phone,
                address,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Supplier> query(
            @RequestParam("pages") Integer pages,
            @RequestParam("key") String key
    ) {
        return supplierService.query(pages, key);
    }
}