package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Material;

/**
 * 材料表(Material)表服务接口
 *
 * @author MoYz
 * @since 2021-03-16 17:50:13
 */
public interface MaterialService extends IService<Material> {
    /**
     * 添 加 操 作
     *
     * @param material -> Material实例
     * @return bool
     * @author Moyz
     * @date 2021-03-16 17:50:13
     */
    Boolean add(Material material);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-16 17:50:13
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param material -> Material实例
     * @return bool
     * @author Moyz
     * @date 2021-03-16 17:50:13
     */
    Boolean update(Material material);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-16 17:50:13
     */
    Page<Material> query(Integer pages, String key);
}