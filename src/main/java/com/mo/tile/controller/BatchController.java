package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Batch;
import com.mo.tile.service.impl.BatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (Batch)表控制层
 *
 * @author mo
 * @since 2021-01-22 00:35:01
 */
@RestController
@RequestMapping("batch")
public class BatchController {
    /* *
     * 服务对象
     */
    @Autowired
    private BatchServiceImpl batchService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Batch selectOne(Integer id) {
        return batchService.getById(id);
    }

    /* *
     * 分 页 查 询
     */
    @ResponseBody
    @GetMapping("table")
    public Page<Batch> page(@RequestParam("pages") Integer pages) {
        return batchService.selectPage(pages);
    }
}