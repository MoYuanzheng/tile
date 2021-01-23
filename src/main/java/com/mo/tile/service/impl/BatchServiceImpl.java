package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Batch;
import com.mo.tile.mapper.BatchMapper;
import com.mo.tile.service.BatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Batch)表服务实现类
 *
 * @author MoYz
 * @since 2021-01-23 15:21:10
 */
@Service("batchService")
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements BatchService {
    /**
     * 分页查询
     */
    @Resource
    private BatchMapper batchMapper;

    public Page<Batch> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Batch> page = new Page<>(pages, 10);
        batchMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}