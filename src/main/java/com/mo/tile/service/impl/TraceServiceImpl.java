package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Trace;
import com.mo.tile.mapper.TraceMapper;
import com.mo.tile.service.ContainerService;
import com.mo.tile.service.ProductAllService;
import com.mo.tile.service.TraceService;
import com.mo.tile.util.GeneralFunctions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
     * 物流类型为 1
     */
    private static final String TYPE_LOGISTICS = "1";
    @Resource
    ProductAllService productAllService;
    @Resource
    ContainerService containerService;

    /**
     * 创建追溯记录
     */
    @Override
    public Boolean add(Trace trace) {
        if (trace.getType().equals(TYPE_LOGISTICS)) {
            String operator = trace.getOperationPerson();
            String content = trace.getContent();
            List<String> productId = new ArrayList<>();
            productId.add(trace.getProductId());
            /**
             * 1.查询trace.productId()是否存在于product_all表中
             * 1.1.是则直接插入
             * 1.2.否就查询与BIG_ID相关联的SMALL_ID插入到列表中
             */
            String pdtId;
            for (int i = 0; i < productId.size(); i++) {
                pdtId = productId.get(i);
                traceMapper.insert(new Trace(
                        GeneralFunctions.getRandomId(),
                        pdtId,
                        operator,
                        content,
                        "1",
                        "扫码-物流"
                ));
                if (!productAllService.isExist(pdtId)) {
                    //查询所有container表中bigId与trace.productId()相同的记录
                    productId.addAll(containerService.getSmallIdByBigId(pdtId));
                }
            }
        }
        return true;
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
        Page<Trace> page = new Page<>(pages, 100);
        QueryWrapper<Trace> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("product_id", key).or()
                .like("operation_person", key).or()
                .like("content", key).or()
                .like("type", key).or()
                .like("remark", key)
                .orderByAsc("create_time");
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