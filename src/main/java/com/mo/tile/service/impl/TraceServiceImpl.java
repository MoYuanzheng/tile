package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.common.RestResult;
import com.mo.tile.entity.History;
import com.mo.tile.entity.Trace;
import com.mo.tile.mapper.TraceMapper;
import com.mo.tile.service.*;
import com.mo.tile.util.GeneralFunctions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 追溯(Trace)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-13 17:07:34
 */
@Service("traceService")
public class TraceServiceImpl extends ServiceImpl<TraceMapper, Trace> implements TraceService {

    /**
     * 物流类型为 1
     * 装箱拆箱为 2
     * 材料类型为 3
     */
    private static final String TYPE_LOGISTICS = "1";
    private static final String TYPE_CONTAINER = "2";
    private static final String TYPE_MATERIAL = "3";
    @Resource
    ProductAllService productAllService;
    @Resource
    ContainerService containerService;
    @Resource
    private TraceMapper traceMapper;
    @Resource
    private HistoryService historyService;
    @Resource
    private UserService userService;
    @Resource
    MaterialService materialService;
    @Resource
    private BatchService batchService;

    /**
     * 创建追溯记录
     */
    @Override
    public RestResult add(Trace trace) {
        RestResult result = RestResult.newInstance();
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
        //此处应判断是否写入成功
        result.setMsg("OK");
        result.setCode(200);
        result.setData("成功写入追溯表");
        return result;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public RestResult del(String id) {
        RestResult result = RestResult.newInstance();
        if (traceMapper.deleteById(id) == 1) {
            result.setMsg("删除成功！");
            result.setCode(200);
        } else {
            result.setMsg("删除失败！请重试");
            result.setCode(404);
        }
        return result;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public RestResult update(Trace trace) {
        RestResult result = RestResult.newInstance();
        if (traceMapper.updateById(trace) == 1) {
            result.setMsg("修改成功！");
            result.setCode(200);
        } else {
            result.setMsg("修改失败！请重试");
            result.setCode(404);
        }
        return result;
    }

    /**
     * 物 流 追 溯
     */
    @Override
    public List<Trace> queryLogistics(String productId) {
        QueryWrapper<Trace> wrapper = new QueryWrapper<>();
        wrapper.
                eq("product_id", productId)
                .orderByAsc("update_time");
        List<Trace> logistics = traceMapper.selectList(wrapper);
        //写入用户追溯历史
        if (logistics.get(0) != null) {
            historyService.add(
                    new History(
                            GeneralFunctions.getRandomId(),
                            userService.getLoggedUserInfo().getId(),
                            productId,
                            "By trace"
                    ));
        }
        return logistics;
    }

    /**
     * 追 溯 原 材 料
     */
    @Override
    public Map<String, Object> queryMaterial(String productId) {
        String batchId = productAllService.getById(productId).getBatch();
        String materialId = batchService.getById(batchId).getMaterial();
        Map<String, Object> materialMap = new HashMap<>();
        for (String materialIdSingle : materialId.split(",")) {
            //依次查询原材料
            materialService.getById(materialIdSingle);
            materialMap.put(materialService.getById(materialIdSingle).getAlias(),
                    materialService.getById(materialIdSingle));
        }
        return materialMap;
    }
}