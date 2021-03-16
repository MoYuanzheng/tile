package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Container;
import com.mo.tile.entity.Packet;
import com.mo.tile.mapper.ContainerMapper;
import com.mo.tile.service.ContainerService;
import com.mo.tile.service.PacketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * (Container)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-15 15:56:25
 */
@Service("containerService")
public class ContainerServiceImpl extends ServiceImpl<ContainerMapper, Container> implements ContainerService {

    @Resource
    private ContainerMapper containerMapper;

    @Resource
    private PacketService packetService;

    @Resource
    private com.mo.tile.service.PacketStatisticsService packetStatisticsService;

    /**
     * 添 加 两 个 盒 子 之 间 包 含 操 作
     */
    @Override
    public Boolean add(Container container) {
        //首先判断小盒子是否已在数据表中（在则说明已被装入某个箱子，则不能再进行分配）
        QueryWrapper<Container> wrapperSmall = new QueryWrapper<>();
        wrapperSmall.eq("small_id", container.getSmallId());
        if (count(wrapperSmall) > 0) {
            return false;
        }
        //大盒子
        Packet packetBig;
        QueryWrapper<Packet> wrapper = new QueryWrapper<>();
        wrapper.eq("id", container.getBigId());
        packetBig = packetService.getOne(wrapper);

        //如果该盒子已被使用且剩余容量大于1
        if (packetBig.getUseFlag() == 1) {
            if (packetBig.getSurplus() >= 1) {
                /**
                 * √0. 进行分配
                 * √1.更新大盒子剩余容量
                 */
                packetBig.setSurplus(packetBig.getSurplus() - 1);
                //创建关系并更新剩余容量
                return createLink(container) && packetService.update(packetBig);
            } else {
                return false;
            }
        } else {
            /**
             * √0. 进行分配
             * √1.更新大盒子剩余容量
             * √2.更新大盒子剩余库存
             * √3.更新大盒子标志位
             */
            packetBig.setUseFlag(1);
            packetBig.setSurplus(packetBig.getSurplus() - 1);
            return packetStatisticsService.updateSurplusBySize(packetBig.getSize()) && createLink(container) && packetService.update(packetBig);
        }


    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return containerMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Container container) {
        return containerMapper.updateById(container) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Container> query(Integer pages, String key) {
        Page<Container> page = new Page<>(pages, 10);
        QueryWrapper<Container> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("big_size", key).or()
                .like("small_size", key).or()
                .like("remark", key);
        containerMapper.selectPage(page, wrapper);
        return page;
    }

    /**
     * 两个盒子之间建立链接
     */
    @Override
    public Boolean createLink(Container container) {
        container.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 18));
        return containerMapper.insert(container) == 1;
    }
}