package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Dealer;
import com.mo.tile.mapper.DealerMapper;
import com.mo.tile.service.DealerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 经销商(Dealer)表服务实现类
 *
 * @author MoYz
 * @since 2021-02-09 15:12:13
 */
@Service("dealerService")
public class DealerServiceImpl extends ServiceImpl<DealerMapper, Dealer> implements DealerService {

    @Resource
    private DealerMapper dealerMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Dealer dealer) {
        return dealerMapper.insert(dealer) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return dealerMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Dealer dealer) {
        return dealerMapper.updateById(dealer) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Dealer> query(Integer pages, String key) {
        Page<Dealer> page = new Page<>(pages, 10);
        QueryWrapper<Dealer> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("alias", key).or()
                .like("full_name", key).or()
                .like("grade", key).or()
                .like("address", key).or()
                .like("area", key).or()
                .like("remark", key);
        dealerMapper.selectPage(page, wrapper);
        return page;
    }
}