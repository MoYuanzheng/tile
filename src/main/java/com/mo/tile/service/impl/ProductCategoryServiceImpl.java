package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.ProductCategory;
import com.mo.tile.mapper.ProductCategoryMapper;
import com.mo.tile.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 产品(ProductCategory)表服务实现类
 *
 * @author MoYz
 * @since 2021-02-17 18:28:06
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(ProductCategory productCategory) {
        return productCategoryMapper.insert(productCategory) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return productCategoryMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(ProductCategory productCategory) {
        return productCategoryMapper.updateById(productCategory) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<ProductCategory> query(Integer pages, String key) {
        Page<ProductCategory> page = new Page<>(pages, 10);
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("type", key).or()
                .like("cn_name", key).or()
                .like("price", key).or()
                .like("remark", key);
        productCategoryMapper.selectPage(page, wrapper);
        return page;
    }
}