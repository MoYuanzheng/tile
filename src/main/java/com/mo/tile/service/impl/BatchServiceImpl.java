package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.bean.Batch;
import com.mo.tile.mapper.BatchMapper;
import com.mo.tile.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Batch)表服务实现类
 *
 * @author mo
 * @since 2021-01-22 00:23:37
 */
@Service("batchService")
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements BatchService {
    /*
     * 分页查询
     * */
    @Autowired
    private BatchMapper batchMapper;

    public Page<Batch> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Batch> page = new Page<>(pages, 10);
        batchMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}