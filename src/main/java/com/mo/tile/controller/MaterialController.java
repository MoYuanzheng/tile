package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Material;
import com.mo.tile.service.impl.MaterialServiceImpl;
import com.mo.tile.util.GeneralFunctions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 材料表(Material)表控制层
 *
 * @author MoYz
 * @since 2021-03-16 17:50:13
 */
@Api(tags = "材料表相关")
@RestController
@RequestMapping("material")
public class MaterialController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialServiceImpl materialService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("alias") @ApiParam("商品代号，对应材料表主键") String alias,
            @RequestParam("supplier") @ApiParam("供货商") String supplier,
            @RequestParam("surplus") @ApiParam("剩余货物数量") Integer surplus,
            @RequestParam("total") @ApiParam("该批货物总重量") Integer total,
            @RequestParam("deadline") @ApiParam("截止日期时间戳") String deadline,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return materialService.add(new Material(
                GeneralFunctions.getRandomId(),
                alias,
                supplier,
                surplus,
                total,
                deadline,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return materialService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("alias") @ApiParam("商品代号，对应材料表主键") String alias,
            @RequestParam("supplier") @ApiParam("供货商") String supplier,
            @RequestParam("surplus") @ApiParam("剩余货物数量") Integer surplus,
            @RequestParam("total") @ApiParam("该批货物总重量") Integer total,
            @RequestParam("deadline") @ApiParam("截止日期时间戳") String deadline,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return materialService.update(new Material(
                id,
                alias,
                supplier,
                surplus,
                total,
                deadline,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Material> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return materialService.query(pages, key);
    }
}