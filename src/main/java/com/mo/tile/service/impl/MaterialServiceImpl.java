package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Material;
import com.mo.tile.mapper.MaterialMapper;
import com.mo.tile.service.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Material)表服务实现类
 *
 * @author MoYz
 * @since 2021-01-23 15:21:06
 */
@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {
    /**
     * 分页查询
     */
    @Resource
    private MaterialMapper materialMapper;

    public Page<Material> selectPage(Integer pages) {
        System.out.println("PageServiceImpl");
        Page<Material> page = new Page<>(pages, 10);
        materialMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        return page;
    }
}