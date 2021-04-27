package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Batch;
import com.mo.tile.entity.ProductAll;
import com.mo.tile.mapper.BatchMapper;
import com.mo.tile.service.BatchService;
import com.mo.tile.service.ProductAllService;
import com.mo.tile.service.TraceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单批次表(Batch)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-09 22:43:17
 */
@Service("batchService")
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements BatchService {

    @Resource
    private BatchMapper batchMapper;
    @Resource
    private BatchService batchService;
    @Resource
    private ProductAllService productAllService;
    @Resource
    private TraceService traceService;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Batch batch) {
        if (batchMapper.insert(batch) == 1) {
            System.out.println(batch);
            return productAllService.batchCreation(batch.getTotal(), batch.getId(), batch.getProductType());
        } else {
            return false;
        }
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        QueryWrapper<ProductAll> wrapperProductAll = new QueryWrapper<>();
        wrapperProductAll.eq("batch", id);
        return batchMapper.deleteById(id) == 1 && productAllService.remove(wrapperProductAll);
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Batch batch) {
        return batchMapper.updateById(batch) == 1;
    }

    /**
     * 修 改 完 成 时 间 操 作
     */
    @Override
    public Boolean updateCompleteTime(String id, String completeTime) {
        UpdateWrapper<Batch> wrapperBatch = new UpdateWrapper<>();
        wrapperBatch
                .eq("id", id)
                .set("complete_time", completeTime);

        UpdateWrapper<ProductAll> wrapperProductAll = new UpdateWrapper<>();
        wrapperProductAll
                .eq("batch", id)
                .set("manufacture_date", completeTime);
        return batchService.update(wrapperBatch) && productAllService.update(wrapperProductAll);
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Batch> query(Integer pages, String key) {
        Page<Batch> page = new Page<>(pages, 10);
        QueryWrapper<Batch> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("operator", key).or()
                .like("complete_time", key).or()
                .like("product_type", key).or()
                .like("total", key).or()
                .like("remark", key);
        batchMapper.selectPage(page, wrapper);
        return page;
    }
}