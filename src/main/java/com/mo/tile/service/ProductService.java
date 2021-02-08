package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * (Product)表服务接口
 *
 * @author MoYz
 * @since 2021-01-23 15:31:43
 */
public interface ProductService extends IService<Product> {

    /**
     * 添 加 操 作
     *
     * @param product -> 产品对象
     * @return bool
     * @author Moyz
     * @date 2021/02/08 21:03
     */
    Boolean add(Product product);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021/02/08 21:03
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param product -> 产品对象
     * @return bool
     * @author Moyz
     * @date 2021/02/08 21:03
     */
    Boolean update(Product product);

    /**
     * 分 页 查 询
     *
     * @param pages -> 页数
     * @return bool
     * @author Moyz
     * @date 2021/02/08 21:03
     */
    Page<Product> selectPage(Integer pages);

    /**
     * 条 件 查 询
     *
     * @param key -> 关键字
     * @return List<Product>
     * @author Moyz
     * @date 2021/02/08 21:03
     */
    List<Map<String, Object>> query(String key);
}