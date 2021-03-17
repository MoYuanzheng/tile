package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.DealerCategory;
import com.mo.tile.mapper.DealerCategoryMapper;
import com.mo.tile.service.DealerCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 分销商分类表(DealerCategory)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-16 22:26:30
 */
@Service("dealerCategoryService")
public class DealerCategoryServiceImpl extends ServiceImpl<DealerCategoryMapper, DealerCategory> implements DealerCategoryService {

    @Resource
    private DealerCategoryMapper dealerCategoryMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(DealerCategory dealerCategory) {
        return dealerCategoryMapper.insert(dealerCategory) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return dealerCategoryMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(DealerCategory dealerCategory) {
        return dealerCategoryMapper.updateById(dealerCategory) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<DealerCategory> query(Integer pages, String key) {
        Page<DealerCategory> page = new Page<>(pages, 10);
        QueryWrapper<DealerCategory> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("cn_name", key).or()
                .like("remark", key);
        dealerCategoryMapper.selectPage(page, wrapper);
        return page;
    }
}