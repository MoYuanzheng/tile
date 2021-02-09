package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2021-02-09 15:12:16
 */
@Service("supplierService")
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Supplier supplier) {
        return supplierMapper.insert(supplier) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return supplierMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Supplier supplier) {
        return supplierMapper.updateById(supplier) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Supplier> query(Integer pages, String key) {
        Page<Supplier> page = new Page<>(pages, 10);
        QueryWrapper<Supplier> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("material", key).or()
                .like("full_name", key).or()
                .like("header", key).or()
                .like("phone", key).or()
                .like("address", key).or()
                .like("remark", key);
        supplierMapper.selectPage(page, wrapper);
        return page;
    }
}