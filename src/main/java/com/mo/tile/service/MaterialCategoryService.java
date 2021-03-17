package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.MaterialCategory;

/**
 * 材料类图(MaterialCategory)表服务接口
 *
 * @author MoYz
 * @since 2021-03-16 22:26:44
 */
public interface MaterialCategoryService extends IService<MaterialCategory> {
    /**
     * 添 加 操 作
     *
     * @param materialCategory -> MaterialCategory实例
     * @return bool
     * @author Moyz
     * @date 2021-03-16 22:26:44
     */
    Boolean add(MaterialCategory materialCategory);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-16 22:26:44
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param materialCategory -> MaterialCategory实例
     * @return bool
     * @author Moyz
     * @date 2021-03-16 22:26:44
     */
    Boolean update(MaterialCategory materialCategory);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-16 22:26:44
     */
    Page<MaterialCategory> query(Integer pages, String key);
}