package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Material;
import com.mo.tile.service.impl.MaterialServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Material)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 15:25:32
 */
@RestController
@RequestMapping("material")
public class MaterialController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialServiceImpl materialService;

    /**
     * 添 加
     */
    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") String id,
            @RequestParam("cnName") String cnName,
            @RequestParam("enName") String enName,
            @RequestParam("remark") String remark
    ) {
        return materialService.update(new Material(
                id,
                cnName,
                enName,
                remark
        ));
    }

    /**
     * 删 除
     */
    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("账号") String id
    ) {
        return materialService.del(id);
    }

    /**
     * 修 改
     */
    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") String id,
            @RequestParam("cnName") String cnName,
            @RequestParam("enName") String enName,
            @RequestParam("remark") String remark
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
            @RequestParam("pages") Integer pages,
            @RequestParam("key") String key
    ) {
        return materialService.query(pages, key);
    }
}