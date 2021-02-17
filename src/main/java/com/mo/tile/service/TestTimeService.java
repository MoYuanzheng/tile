package com.mo.tile.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mo.tile.entity.TestTime;

/**
 * 测试表(TestTime)表服务接口
 *
 * @author MoYz
 * @since 2021-02-09 16:34:27
 */
public interface TestTimeService extends IService<TestTime> {
    /**
     * 添 加 操 作
     *
     * @param testTime -> TestTime实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 16:34:27
     */
    Boolean add(TestTime testTime);

    /**
     * 删 除 操 作
     *
     * @param id -> 主键
     * @return bool
     * @author Moyz
     * @date 2021-02-09 16:34:27
     */
    Boolean del(String id);

    /**
     * 修 改 操 作
     *
     * @param testTime -> TestTime实例
     * @return bool
     * @author Moyz
     * @date 2021-02-09 16:34:27
     */
    Boolean update(TestTime testTime);

    /**
     * 模 糊 查 询 及 分 页
     *
     * @param pages -> 页数
     * @param key   -> 关键字
     * @return page
     * @author Moyz
     * @date 2021-02-09 16:34:27
     */
    Page<TestTime> query(Integer pages, String key);
}