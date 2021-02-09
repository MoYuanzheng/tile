package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Product;
import com.mo.tile.mapper.ProductMapper;
import com.mo.tile.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Product)表服务实现类
 *
 * @author MoYz
 * @since 2021-01-23 15:31:45
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Product product) {
        return productMapper.insert(product) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return productMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Product product) {
        return productMapper.updateById(product) == 1;
    }

    /**
     * 模 糊 查 询 及 分页
     */
    @Override
    public Page<Product> query(Integer pages, String key) {
        Page<Product> page = new Page<>(pages, 10);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper
                .like("type", key).or()
                .like("batch", key).or()
                .like("price", key).or()
                .like("qr_code", key).or()
                .like("remark", key).or()
                .like("id", key);
        productMapper.selectPage(page, wrapper);
        return page;
    }

}