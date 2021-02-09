package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Dealer;

/**
 * 经销商(Dealer)表服务接口
 *
 * @author MoYz
 * @since 2021-02-09 15:12:13
 */
public interface DealerService extends IService<Dealer> {
    /**
     * 添 加 操 作
     *
     * @param dealer -> Dealer实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 15:12:13
     */
    Boolean add(Dealer dealer);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-09 15:12:13
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param dealer -> Dealer实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 15:12:13
     */
    Boolean update(Dealer dealer);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-02-09 15:12:13
     */
    Page<Dealer> query(Integer pages, String key);
}