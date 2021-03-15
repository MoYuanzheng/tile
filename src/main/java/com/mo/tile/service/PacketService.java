package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Packet;

/**
 * 大包装追溯码(Packet)表服务接口
 *
 * @author MoYz
 * @since 2021-03-15 15:34:37
 */
public interface PacketService extends IService<Packet> {
    /**
     * 添 加 操 作
     *
     * @param packet -> Packet实例
     * @return bool
     * @author Moyz
     * @date 2021-03-15 15:34:37
     */
    Boolean add(Packet packet);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-15 15:34:37
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param packet -> Packet实例
     * @return bool
     * @author Moyz
     * @date 2021-03-15 15:34:37
     */
    Boolean update(Packet packet);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-15 15:34:37
     */
    Page<Packet> query(Integer pages, String key);

    /**
     * 批量创建包装盒
     *
     * @param number 数量
     * @param size   尺寸
     * @return bool
     * @author Moyz
     * @date 2021/03/15 16:09
     */
    Boolean largeAddition(Integer number, Integer size);
}