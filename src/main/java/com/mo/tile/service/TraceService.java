package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Trace;

/**
 * (Trace)表服务接口
 *
 * @author MoYz
 * @since 2021-03-12 21:15:29
 */
public interface TraceService extends IService<Trace> {
    /**
     * 添 加 操 作
     *
     * @param trace -> Trace实例
     * @return bool
     * @author Moyz
     * @date 2021-03-12 21:15:29
     */
    Boolean add(Trace trace);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-12 21:15:29
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param trace -> Trace实例
     * @return bool
     * @author Moyz
     * @date 2021-03-12 21:15:29
     */
    Boolean update(Trace trace);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-12 21:15:29
     */
    Page<Trace> query(Integer pages, String key);
}