package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Trace;
import com.mo.tile.mapper.TraceMapper;
import com.mo.tile.service.TraceService;
import com.mo.tile.util.GeneralFunctions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 追溯(Trace)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-13 17:07:34
 */
@Service("traceService")
public class TraceServiceImpl extends ServiceImpl<TraceMapper, Trace> implements TraceService {

    @Resource
    private TraceMapper traceMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Trace trace) {
        return traceMapper.insert(trace) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return traceMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Trace trace) {
        return traceMapper.updateById(trace) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Trace> query(Integer pages, String key) {
        Page<Trace> page = new Page<>(pages, 10);
        QueryWrapper<Trace> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("product_id", key).or()
                .like("operation_person", key).or()
                .like("content", key).or()
                .like("type", key).or()
                .like("remark", key);
        traceMapper.selectPage(page, wrapper);
        return page;
    }

    /**
     * 订单与原材料建立联系
     */
    @Override
    public Boolean batchMaterial(String batchId, String materialId, String operator) {
        return add(new Trace(
                GeneralFunctions.getRandomId(),
                batchId,
                operator,
                materialId,
                "3",
                null
        ));
    }
}