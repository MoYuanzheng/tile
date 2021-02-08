package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Batch;

import java.util.List;
import java.util.Map;

/**
 * 订单表(Batch)表服务接口
 *
 * @author MoYz
 * @since 2021-02-09 00:46:51
 */
public interface BatchService extends IService<Batch> {
    /**
     * 添 加 操 作
     *
     * @param batch -> Batch实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:51
     */
    Boolean add(Batch batch);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:51
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param batch -> Batch实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:51
     */
    Boolean update(Batch batch);

    /**
     * 分 页 查 询
     *
     * @param pages -> 页数
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:51
     */
    Page<Batch> selectPage(Integer pages);

    /**
     * 条 件 查 询
     *
     * @param key -> 关键字
     * @return List<batch>
     * @author Moyz
     * @date 2021-02-09 00:46:51
     */
    List<Map<String, Object>> query(String key);
}