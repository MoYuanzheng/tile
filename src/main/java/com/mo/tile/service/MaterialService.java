package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Material;

import java.util.List;
import java.util.Map;

/**
 * (Material)表服务接口
 *
 * @author MoYz
 * @since 2021-02-09 00:46:53
 */
public interface MaterialService extends IService<Material> {
    /**
     * 添 加 操 作
     *
     * @param material -> Material实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:53
     */
    Boolean add(Material material);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:53
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param material -> Material实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:53
     */
    Boolean update(Material material);

    /**
     * 分 页 查 询
     *
     * @param pages -> 页数
     * @return bool
     * @author Moyz
     * @date 2021-02-09 00:46:53
     */
    Page<Material> selectPage(Integer pages);

    /**
     * 条 件 查 询
     *
     * @param key -> 关键字
     * @return List<material>
     * @author Moyz
     * @date 2021-02-09 00:46:53
     */
    List<Map<String, Object>> query(String key);
}