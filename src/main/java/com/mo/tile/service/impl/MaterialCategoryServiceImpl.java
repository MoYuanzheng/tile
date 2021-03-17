package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.MaterialCategory;
import com.mo.tile.mapper.MaterialCategoryMapper;
import com.mo.tile.service.MaterialCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 材料类图(MaterialCategory)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-16 22:26:44
 */
@Service("materialCategoryService")
public class MaterialCategoryServiceImpl extends ServiceImpl<MaterialCategoryMapper, MaterialCategory> implements MaterialCategoryService {

    @Resource
    private MaterialCategoryMapper materialCategoryMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(MaterialCategory materialCategory) {
        return materialCategoryMapper.insert(materialCategory) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return materialCategoryMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(MaterialCategory materialCategory) {
        return materialCategoryMapper.updateById(materialCategory) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<MaterialCategory> query(Integer pages, String key) {
        Page<MaterialCategory> page = new Page<>(pages, 10);
        QueryWrapper<MaterialCategory> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("cn_name", key).or()
                .like("levels", key).or()
                .like("remark", key);
        materialCategoryMapper.selectPage(page, wrapper);
        return page;
    }
}