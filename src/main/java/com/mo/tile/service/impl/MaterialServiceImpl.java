package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.Material;
import com.mo.tile.mapper.MaterialMapper;
import com.mo.tile.service.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 材料(Material)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-09 22:42:37
 */
@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Resource
    private MaterialMapper materialMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(Material material) {
        return materialMapper.insert(material) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return materialMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(Material material) {
        return materialMapper.updateById(material) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<Material> query(Integer pages, String key) {
        Page<Material> page = new Page<>(pages, 10);
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("cn_name", key).or()
                .like("en_name", key).or()
                .like("remark", key);
        materialMapper.selectPage(page, wrapper);
        return page;
    }
}