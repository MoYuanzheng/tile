package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Packet;
import com.mo.tile.entity.PacketStatistics;
import com.mo.tile.mapper.PacketMapper;
import com.mo.tile.service.PacketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 大包装追溯码(Packet)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-15 15:34:37
 */
@Service("packetService")
public class PacketServiceImpl extends ServiceImpl<PacketMapper, Packet> implements PacketService {

    @Resource
    private PacketMapper packetMapper;
    @Resource
    private PacketStatisticsServiceImpl packetStatisticsService;

    /**
     * 批 量 创 建 包 装 盒
     */
    @Override
    public Boolean largeAddition(Integer total, Integer size) {
        int number = total;
        while (number != 0) {
            add(new Packet(
                    UUID.randomUUID().toString().replace("-", "").substring(0, 18),
                    size,
                    size
            ));
            number--;
        }
        //更新包装盒统计表
        //拿到库存数据
        PacketStatistics packetStatistics;
        QueryWrapper<PacketStatistics> wrapperQuery = new QueryWrapper<>();
        wrapperQuery.eq("size", size);
        packetStatistics = packetStatisticsService.getOne(wrapperQuery);
        //更新库存数据
        UpdateWrapper<PacketStatistics> wrapperUpdate = new UpdateWrapper<>();
        wrapperUpdate.
                eq("size", size).
                set("surplus", total + packetStatistics.getSurplus()).
                set("total", total + packetStatistics.getTotal());
        packetStatisticsService.update(wrapperUpdate);
        return true;
    }

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Packet packet) {
        return packetMapper.insert(packet) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return packetMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Packet packet) {
        return packetMapper.updateById(packet) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Packet> query(Integer pages, String key) {
        Page<Packet> page = new Page<>(pages, 10);
        QueryWrapper<Packet> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("size", key).or()
                .like("remark", key);
        packetMapper.selectPage(page, wrapper);
        return page;
    }
}