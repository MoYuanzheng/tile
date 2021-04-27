package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.common.RestResult;
import com.mo.tile.entity.Trace;

import java.util.List;
import java.util.Map;

/**
 * 追溯(Trace)表服务接口
 *
 * @author MoYz
 * @since 2021-03-13 17:07:34
 */
public interface TraceService extends IService<Trace> {
    /**
     * 添 加 操 作
     *
     * @param trace -> Trace实例
     * @return bool
     * @author Moyz
     * @date 2021-03-13 17:07:34
     */
    RestResult add(Trace trace);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-13 17:07:34
     */
    RestResult del(String id);

    /**
     * 修 改 操 作
     *
     * @param trace -> Trace实例
     * @return bool
     * @author Moyz
     * @date 2021-03-13 17:07:34
     */
    RestResult update(Trace trace);

    /**
     * 物 流 追 溯
     *
     * @param productId -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-13 17:07:34
     */
    List<Trace> queryLogistics(String productId);

    /**
     * 原 材 料 追 溯
     *
     * @param productId -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-13 17:07:34
     */
    Map<String, Object> queryMaterial(String productId);

}