package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * (Supplier)表服务接口
 *
 * @author MoYz
 * @since 2021-02-09 00:46:52
 */
public interface SupplierService extends IService<Supplier> {
    /**
     * 添 加 操 作
     *
     * @param supplier -> Supplier实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:52
     */
    Boolean add(Supplier supplier);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:52
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param supplier -> Supplier实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:52
     */
    Boolean update(Supplier supplier);

    /**
     * 分 页 查 询
     *
     * @param pages -> 页数
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:52
     */
    Page<Supplier> selectPage(Integer pages);

    /**
     * 条 件 查 询
     *
     * @param key -> 关键字
     * @return List<supplier>
     * @author Moyz
     * @date 2021-02-09 00:46:52
     */
    List<Map<String, Object>> query(String key);
}