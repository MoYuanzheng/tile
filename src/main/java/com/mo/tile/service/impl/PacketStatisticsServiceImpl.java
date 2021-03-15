package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.PacketStatistics;
import com.mo.tile.mapper.PacketStatisticsMapper;
import com.mo.tile.service.PacketStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 包装盒数量统计(PacketStatistics)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-15 16:56:54
 */
@Service("packetStatisticsService")
public class PacketStatisticsServiceImpl extends ServiceImpl<PacketStatisticsMapper, PacketStatistics> implements PacketStatisticsService {

    @Resource
    private PacketStatisticsMapper packetStatisticsMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(PacketStatistics packetStatistics) {
        return packetStatisticsMapper.insert(packetStatistics) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return packetStatisticsMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(PacketStatistics packetStatistics) {
        return packetStatisticsMapper.updateById(packetStatistics) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<PacketStatistics> query(Integer pages, String key) {
        Page<PacketStatistics> page = new Page<>(pages, 10);
        QueryWrapper<PacketStatistics> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("size", key).or()
                .like("surplus", key).or()
                .like("total", key).or()
                .like("remark", key);
        packetStatisticsMapper.selectPage(page, wrapper);
        return page;
    }
}