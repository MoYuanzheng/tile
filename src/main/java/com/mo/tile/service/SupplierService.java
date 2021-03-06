package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Supplier;

/**
 * 供应商(Supplier)表服务接口
 *
 * @author MoYz
 * @since 2021-03-09 22:40:04
 */
public interface SupplierService extends IService<Supplier> {
    /**
     * 添 加 操 作
     *
     * @param supplier -> Supplier实例
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:40:04
     */
    Boolean add(Supplier supplier);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:40:04
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param supplier -> Supplier实例
     * @return bool
     * @author Moyz
     * @date 2021-03-09 22:40:04
     */
    Boolean update(Supplier supplier);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-09 22:40:04
     */
    Page<Supplier> query(Integer pages, String key);
}