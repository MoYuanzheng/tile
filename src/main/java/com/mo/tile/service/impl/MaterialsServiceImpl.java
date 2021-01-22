package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Materials;
import com.mo.tile.mapper.MaterialsMapper;
import com.mo.tile.service.MaterialsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Materials)表服务实现类
 *
 * @author mo
 * @since 2021-01-22 00:20:10
 */
@Service("materialsService")
public class MaterialsServiceImpl extends ServiceImpl<MaterialsMapper, Materials> implements MaterialsService {
    /**
     * 分页查询
     * */
    @Resource
    private MaterialsMapper materialsMapper;

    public Page<Materials> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Materials> page = new Page<>(pages, 10);
        materialsMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}