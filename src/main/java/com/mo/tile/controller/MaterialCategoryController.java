package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.MaterialCategory;
import com.mo.tile.service.impl.MaterialCategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 材料类图(MaterialCategory)表控制层
 *
 * @author MoYz
 * @since 2021-03-16 22:26:44
 */
@Api(tags = "材料类图相关")
@RestController
@RequestMapping("materialCategory")
public class MaterialCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialCategoryServiceImpl materialCategoryService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键，材料代号") String id,
            @RequestParam("cnName") @ApiParam("名字") String cnName,
            @RequestParam("levels") @ApiParam("品级") Integer levels,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return materialCategoryService.add(new MaterialCategory(
                id,
                cnName,
                levels,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return materialCategoryService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键，材料代号") String id,
            @RequestParam("cnName") @ApiParam("名字") String cnName,
            @RequestParam("levels") @ApiParam("品级") Integer levels,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return materialCategoryService.update(new MaterialCategory(
                id,
                cnName,
                levels,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<MaterialCategory> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return materialCategoryService.query(pages, key);
    }
}