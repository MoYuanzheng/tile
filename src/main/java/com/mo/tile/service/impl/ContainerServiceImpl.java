package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Container;
import com.mo.tile.entity.Packet;
import com.mo.tile.mapper.ContainerMapper;
import com.mo.tile.service.ContainerService;
import com.mo.tile.service.PacketService;
import com.mo.tile.util.GeneralFunctions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
        //查询小盒子是否在产品表中， 是->拿到SIZE,否->size  = 1

        //拿到小盒子容量
        Packet packetSmall;
        QueryWrapper<Packet> wrapperSmallPacket = new QueryWrapper<>();
        wrapperSmallPacket.eq("id", container.getSmallId());
        packetSmall = packetService.getOne(wrapperSmallPacket);
        //packet表中有小盒子，就使flag = true
        boolean flag = packetService.count(wrapperSmallPacket) > 0;

        //拿到大盒子信息
        Packet packetBig;
        QueryWrapper<Packet> wrapper = new QueryWrapper<>();
        wrapper.eq("id", container.getBigId());
        packetBig = packetService.getOne(wrapper);

        int packetSize = 1;

        if (flag) {
            packetSize = packetSmall.getSize();
        }
        //如果剩余容量大于小盒子体积
        if (packetBig.getSurplus() >= packetSize) {
            //如果该大盒子已被使用
            if (packetBig.getUseFlag() == 1) {
                /**
                 * √ 0. 进行分配
                 * √ 1.更新大盒子剩余容量（减去小盒子容量）
                 */
                packetBig.setSurplus(packetBig.getSurplus() - packetSize);
                //创建关系并更新剩余容量
                return createLink(container) && packetService.update(packetBig);

            } else {
                /**
                 * √ 0. 进行分配
                 * √ 1.更新大盒子剩余容量（减去小盒子容量）
                 * √ 2.更新大盒子剩余库存
                 * √ 3.更新大盒子标志位
                 */
                packetBig.setUseFlag(1);
                packetBig.setSurplus(packetBig.getSurplus() - packetSize);
                return packetStatisticsService.updateSurplusBySize(packetBig.getSize())
                        && createLink(container) && packetService.update(packetBig);
            }
        }
        return false;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String bigId, String smallId) {
        QueryWrapper<Container> wrapper = new QueryWrapper<>();
        wrapper.
                eq("small_id", bigId).
                eq("big_id", smallId).
                or().
                eq("small_id", smallId).
                eq("big_id", bigId);
        return remove(wrapper);
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
     * 简单添加两个盒子之间包含关系(add 函数的子方法)
     */
    @Override
    public Boolean createLink(Container container) {
        container.setId(GeneralFunctions.getRandomId());
        return containerMapper.insert(container) == 1;
    }

    /**
     * 通过大盒子ID，找到关联的小盒子ID列表
     */
    @Override
    public List<String> getSmallIdByBigId(String bigId) {
        QueryWrapper<Container> wrapper = new QueryWrapper<>();
        wrapper.eq("big_id", bigId);
        //拿到所有关于大盒子的数据
        List<Container> containerListByBigId = list(wrapper);
        //找出小盒子ID
        return containerListByBigId.stream().map(Container::getSmallId).collect(Collectors.toList());
    }

    /**
     * 拆箱操作未写
     */
}