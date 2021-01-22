package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Products;
import com.mo.tile.mapper.ProductsMapper;
import com.mo.tile.service.ProductsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Naruto
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

    /**
     * 分页查询
     */
    @Resource
    private ProductsMapper productsMapper;

    public Page<Products> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Products> page = new Page<>(pages, 10);
        productsMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}