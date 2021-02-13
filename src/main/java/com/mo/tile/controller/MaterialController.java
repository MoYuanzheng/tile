package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Material;
import com.mo.tile.service.impl.MaterialServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 材料(Material)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 17:03:10
 */
@Api(tags = "材料相关")
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
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("cnName") @ApiParam("中文名") String cnName,
            @RequestParam("enName") @ApiParam("英文名") String enName,
            @RequestParam("remark") String remark
    ) {
        return materialService.update(new Material(
                id,
                cnName,
                enName,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("登录账号") String id
    ) {
        return materialService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("cnName") @ApiParam("中文名") String cnName,
            @RequestParam("enName") @ApiParam("英文名") String enName,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return materialService.update(new Material(
                id,
                cnName,
                enName,
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