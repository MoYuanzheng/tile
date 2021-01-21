package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.bean.Suppliers;
import com.mo.tile.mapper.SuppliersMapper;
import com.mo.tile.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Suppliers)表服务实现类
 *
 * @author mo
 * @since 2021-01-22 00:20:10
 */
@Service("suppliersService")
public class SuppliersServiceImpl extends ServiceImpl<SuppliersMapper, Suppliers> implements SuppliersService {
    /*
     * 分页查询
     * */
    @Autowired
    private SuppliersMapper suppliersMapper;

    public Page<Suppliers> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Suppliers> page = new Page<>(pages, 10);
        suppliersMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}