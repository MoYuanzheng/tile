package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Batch;

/**
 * 订单批次表(Batch)表服务接口
 *
 * @author MoYz
 * @since 2021-03-09 22:43:17
 */
public interface BatchService extends IService<Batch> {
    /**
     * 添 加 操 作
     *
     * @param batch    -> Batch实例
     * @param material -> 原材料
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:43:17
     */
    Boolean add(Batch batch);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:43:17
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param batch -> Batch实例
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:43:17
     */
    Boolean update(Batch batch);

    /**
     * 更新订单完成时间
     *
     * @param id           订单ID
     * @param completeTime 完成时间
     * @return bool
     * @author Moyz
     * @date 2021/03/15 11:04
     */
    Boolean updateCompleteTime(String id, String completeTime);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-09 22:43:17
     */
    Page<Batch> query(Integer pages, String key);
}