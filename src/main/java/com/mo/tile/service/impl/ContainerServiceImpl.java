package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Container;
import com.mo.tile.mapper.ContainerMapper;
import com.mo.tile.service.ContainerService;
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

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Container container) {
        container.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 18));
        return containerMapper.insert(container) == 1;
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
}