package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Dealer;
import com.mo.tile.service.impl.DealerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 经销商(Dealer)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 17:03:09
 */
@Api(tags = "经销商相关")
@RestController
@RequestMapping("dealer")
public class DealerController {
    /**
     * 服务对象
     */
    @Resource
    private DealerServiceImpl dealerService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("alias") @ApiParam("别名") String alias,
            @RequestParam("fullName") @ApiParam("全称") String fullName,
            @RequestParam("grade") @ApiParam("经销商等级，1 === 一级经销商") Integer grade,
            @RequestParam("address") @ApiParam("办公地址") String address,
            @RequestParam("area") @ApiParam("销售负责区域") String area,
            @RequestParam("remark") String remark
    ) {
        return dealerService.update(new Dealer(
                id,
                alias,
                fullName,
                grade,
                address,
                area,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("登录账号") String id
    ) {
        return dealerService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("alias") @ApiParam("别名") String alias,
            @RequestParam("fullName") @ApiParam("全称") String fullName,
            @RequestParam("grade") @ApiParam("经销商等级，1 === 一级经销商") Integer grade,
            @RequestParam("address") @ApiParam("办公地址") String address,
            @RequestParam("area") @ApiParam("销售负责区域") String area,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return dealerService.update(new Dealer(
                id,
                alias,
                fullName,
                grade,
                address,
                area,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Dealer> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return dealerService.query(pages, key);
    }
}