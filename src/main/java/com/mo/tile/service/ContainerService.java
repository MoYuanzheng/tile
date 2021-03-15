package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.Container;

/**
 * (Container)表服务接口
 *
 * @author MoYz
 * @since 2021-03-15 15:56:24
 */
public interface ContainerService extends IService<Container> {
    /**
     * 添 加 操 作
     *
     * @param container -> Container实例
     * @return bool
     * @author Moyz
     * @date 2021-03-15 15:56:24
     */
    Boolean add(Container container);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-15 15:56:24
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param container -> Container实例
     * @return bool
     * @author Moyz
     * @date 2021-03-15 15:56:24
     */
    Boolean update(Container container);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-15 15:56:24
     */
    Page<Container> query(Integer pages, String key);
}