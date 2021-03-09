package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.ProductAll;

/**
 * (ProductAll)表服务接口
 *
 * @author MoYz
 * @since 2021-03-09 22:42:16
 */
public interface ProductAllService extends IService<ProductAll> {
    /**
     * 添 加 操 作
     *
     * @param productAll -> ProductAll实例
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:42:16
     */
    Boolean add(ProductAll productAll);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:42:16
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param productAll -> ProductAll实例
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:42:16
     */
    Boolean update(ProductAll productAll);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-09 22:42:16
     */
    Page<ProductAll> query(Integer pages, String key);
}