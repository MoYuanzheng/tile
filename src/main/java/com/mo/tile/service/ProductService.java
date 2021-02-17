package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Product;

/**
 * 产品(Product)表服务接口
 *
 * @author MoYz
 * @since 2021-02-17 18:21:42
 */
public interface ProductService extends IService<Product> {
    /**
     * 添 加 操 作
     *
     * @param product -> Product实例
     * @return bool
     * @author Moyz
     * @date 2021-02-17 18:21:42
     */
    Boolean add(Product product);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-17 18:21:42
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param product -> Product实例
     * @return bool
     * @author Moyz
     * @date 2021-02-17 18:21:42
     */
    Boolean update(Product product);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-02-17 18:21:42
     */
    Page<Product> query(Integer pages, String key);
}