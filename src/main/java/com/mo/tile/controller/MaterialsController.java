package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Materials;
import com.mo.tile.service.impl.MaterialsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Materials)表控制层
 *
 * @author mo
 * @since 2021-01-22 00:35:02
 */
@RestController
@RequestMapping("materials")
public class MaterialsController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialsServiceImpl materialsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Materials selectOne(String id) {
        return materialsService.getById(id);
    }

    /**
     * 分 页 查 询
     */
    @ResponseBody
    @GetMapping("table")
    public Page<Materials> page(@RequestParam("pages") Integer pages) {
        return materialsService.selectPage(pages);
    }
}