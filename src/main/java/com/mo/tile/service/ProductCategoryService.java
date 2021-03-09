package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.ProductCategory;

/**
 * 产品(ProductCategory)表服务接口
 *
 * @author MoYz
 * @since 2021-02-17 18:28:06
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    /**
     * 添 加 操 作
     *
     * @param productCategory -> ProductCategory实例
     * @return bool
     * @author Moyz
     * @date 2021-02-17 18:28:06
     */
    Boolean add(ProductCategory productCategory);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-17 18:28:06
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param productCategory -> ProductCategory实例
     * @return bool
     * @author Moyz
     * @date 2021-02-17 18:28:06
     */
    Boolean update(ProductCategory productCategory);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-02-17 18:28:06
     */
    Page<ProductCategory> query(Integer pages, String key);
}