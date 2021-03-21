package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Supplier;
import com.mo.tile.service.impl.SupplierServiceImpl;
import com.mo.tile.util.GeneralFunctions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 供应商(Supplier)表控制层
 *
 * @author MoYz
 * @since 2021-03-09 22:40:04
 */
@Api(tags = "供应商相关")
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
            @RequestParam("material") @ApiParam("所供应材料") String material,
            @RequestParam("fullName") @ApiParam("供应商全称") String fullName,
            @RequestParam("header") @ApiParam("负责人名字") String header,
            @RequestParam("phone") @ApiParam("联系电话") String phone,
            @RequestParam("address") @ApiParam("联系地址") String address,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return supplierService.add(new Supplier(
                GeneralFunctions.getRandomId(),
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
            @RequestParam("id") @ApiParam("登录账号") String id
    ) {
        return supplierService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("material") @ApiParam("所供应材料") String material,
            @RequestParam("fullName") @ApiParam("供应商全称") String fullName,
            @RequestParam("header") @ApiParam("负责人名字") String header,
            @RequestParam("phone") @ApiParam("联系电话") String phone,
            @RequestParam("address") @ApiParam("联系地址") String address,
            @RequestParam("remark") @ApiParam("备注") String remark
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
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return supplierService.query(pages, key);
    }
}