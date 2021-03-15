package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.PacketStatistics;

/**
 * 包装盒数量统计(PacketStatistics)表服务接口
 *
 * @author MoYz
 * @since 2021-03-15 16:56:54
 */
public interface PacketStatisticsService extends IService<PacketStatistics> {
    /**
     * 添 加 操 作
     *
     * @param packetStatistics -> PacketStatistics实例
     * @return bool
     * @author Moyz
     * @date 2021-03-15 16:56:54
     */
    Boolean add(PacketStatistics packetStatistics);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-15 16:56:54
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param packetStatistics -> PacketStatistics实例
     * @return bool
     * @author Moyz
     * @date 2021-03-15 16:56:54
     */
    Boolean update(PacketStatistics packetStatistics);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-15 16:56:54
     */
    Page<PacketStatistics> query(Integer pages, String key);
}