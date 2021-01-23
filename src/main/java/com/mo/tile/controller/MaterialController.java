package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Material;
import com.mo.tile.service.impl.MaterialServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Material)表控制层
 *
 * @author mo
 * @since 2021-01-23 15:22:37
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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Material selectOne(String id) {
        return materialService.getById(id);
    }

    /**
     * 分 页 查 询
     */
    @ResponseBody
    @GetMapping("table")
    public Page<Material> page(@RequestParam("pages") Integer pages) {
        return materialService.selectPage(pages);
    }
}