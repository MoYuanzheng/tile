package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.ProductAll;
import com.mo.tile.mapper.ProductAllMapper;
import com.mo.tile.service.ProductAllService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * (ProductAll)表服务实现类
 *
 * @author MoYz
 * @since 2021-03-09 22:42:16
 */
@Service("productAllService")
public class ProductAllServiceImpl extends ServiceImpl<ProductAllMapper, ProductAll> implements ProductAllService {

    @Resource
    private ProductAllMapper productAllMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(ProductAll productAll) {
        return productAllMapper.insert(productAll) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return productAllMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(ProductAll productAll) {
        return productAllMapper.updateById(productAll) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<ProductAll> query(Integer pages, String key) {
        Page<ProductAll> page = new Page<>(pages, 10);
        QueryWrapper<ProductAll> wrapper = new QueryWrapper<>();
        wrapper
                .like("id", key).or()
                .like("type", key).or()
                .like("batch", key).or()
                .like("manufacture_date", key).or()
                .like("inspection_date", key).or()
                .like("remark", key);
        productAllMapper.selectPage(page, wrapper);
        return page;
    }

    @Override
    public Boolean batchCreation(int num, String batch, Integer type) {
        boolean flag = true;
        while (num != 0) {
//            if (!) {
//                flag = false;
//                break;
//            }
            add(new ProductAll(UUID.randomUUID().toString().substring(0, 18), type, batch, "批量生产"));
            num--;
        }
        return flag;
    }
}