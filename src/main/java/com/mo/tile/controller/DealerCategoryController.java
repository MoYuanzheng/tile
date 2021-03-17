package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.DealerCategory;
import com.mo.tile.service.impl.DealerCategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 分销商分类表(DealerCategory)表控制层
 *
 * @author MoYz
 * @since 2021-03-16 22:26:30
 */
@Api(tags = "分销商分类表相关")
@RestController
@RequestMapping("dealerCategory")
public class DealerCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private DealerCategoryServiceImpl dealerCategoryService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("区域经销代码") String id,
            @RequestParam("cnName") @ApiParam("中文名") String cnName,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return dealerCategoryService.add(new DealerCategory(
                id,
                cnName,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return dealerCategoryService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("区域经销代码") String id,
            @RequestParam("cnName") @ApiParam("中文名") String cnName,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return dealerCategoryService.update(new DealerCategory(
                id,
                cnName,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<DealerCategory> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return dealerCategoryService.query(pages, key);
    }
}