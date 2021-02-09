package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Dealer;
import com.mo.tile.service.impl.DealerServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 经销商(Dealer)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 15:25:33
 */
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
            @RequestParam("id") String id,
            @RequestParam("alias") String alias,
            @RequestParam("fullName") String fullName,
            @RequestParam("grade") Integer grade,
            @RequestParam("address") String address,
            @RequestParam("area") String area,
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
            @RequestParam("id") @ApiParam("账号") String id
    ) {
        return dealerService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") String id,
            @RequestParam("alias") String alias,
            @RequestParam("fullName") String fullName,
            @RequestParam("grade") Integer grade,
            @RequestParam("address") String address,
            @RequestParam("area") String area,
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

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Dealer> query(
            @RequestParam("pages") Integer pages,
            @RequestParam("key") String key
    ) {
        return dealerService.query(pages, key);
    }
}