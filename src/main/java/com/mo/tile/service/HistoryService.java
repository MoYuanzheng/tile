package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.History;

/**
 * (History)表服务接口
 *
 * @author MoYz
 * @since 2021-04-27 17:38:51
 */
public interface HistoryService extends IService<History> {
    /**
     * 添 加 操 作
     *
     * @param history -> History实例
     * @return bool
     * @author Moyz
     * @date 2021-04-27 17:38:51
     */
    Boolean add(History history);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-04-27 17:38:51
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param history -> History实例
     * @return bool
     * @author Moyz
     * @date 2021-04-27 17:38:51
     */
    Boolean update(History history);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-04-27 17:38:51
     */
    Page<History> query(Integer pages, String key);
}