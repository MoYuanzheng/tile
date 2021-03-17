package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.DealerCategory;

/**
 * 分销商分类表(DealerCategory)表服务接口
 *
 * @author MoYz
 * @since 2021-03-16 22:26:30
 */
public interface DealerCategoryService extends IService<DealerCategory> {
    /**
     * 添 加 操 作
     *
     * @param dealerCategory -> DealerCategory实例
     * @return bool
     * @author Moyz
     * @date 2021-03-16 22:26:30
     */
    Boolean add(DealerCategory dealerCategory);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-03-16 22:26:30
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param dealerCategory -> DealerCategory实例
     * @return bool
     * @author Moyz
     * @date 2021-03-16 22:26:30
     */
    Boolean update(DealerCategory dealerCategory);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-03-16 22:26:30
     */
    Page<DealerCategory> query(Integer pages, String key);
}