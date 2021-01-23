package com.mo.tile.service.impl;

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
    /**
     * 分页查询
     */
    @Resource
    private ProductMapper productMapper;

    public Page<Product> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Product> page = new Page<>(pages, 10);
        productMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}