package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.History;
import com.mo.tile.mapper.HistoryMapper;
import com.mo.tile.service.HistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (History)表服务实现类
 *
 * @author MoYz
 * @since 2021-04-27 17:38:51
 */
@Service("historyService")
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {

    @Resource
    private HistoryMapper historyMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(History history) {
        return historyMapper.insert(history) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return historyMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(History history) {
        return historyMapper.updateById(history) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<History> query(Integer pages, String key) {
        Page<History> page = new Page<>(pages, 10);
        QueryWrapper<History> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("user_id", key).or()
                .like("product_id", key).or()
                .like("remark", key);
        historyMapper.selectPage(page, wrapper);
        return page;
    }
}