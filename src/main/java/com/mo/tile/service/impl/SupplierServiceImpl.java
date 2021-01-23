package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Supplier;
import com.mo.tile.mapper.SupplierMapper;
import com.mo.tile.service.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Supplier)表服务实现类
 *
 * @author MoYz
 * @since 2021-01-23 15:26:32
 */
@Service("supplierService")
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
    /**
     * 分页查询
     */
    @Resource
    private SupplierMapper supplierMapper;

    public Page<Supplier> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Supplier> page = new Page<>(pages, 10);
        supplierMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}