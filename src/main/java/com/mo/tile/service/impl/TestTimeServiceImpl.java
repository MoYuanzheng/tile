package com.mo.tile.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.tile.entity.TestTime;
import com.mo.tile.mapper.TestTimeMapper;
import com.mo.tile.service.TestTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (TestTime)表服务实现类
 *
 * @author MoYz
 * @since 2021-02-09 14:29:54
 */
@Service("testTimeService")
public class TestTimeServiceImpl extends ServiceImpl<TestTimeMapper, TestTime> implements TestTimeService {

    @Resource
    private TestTimeMapper testTimeMapper;

    /**
     * 添 加 操 作
     */
    @Override
    public Boolean add(TestTime testTime) {
        return testTimeMapper.insert(testTime) == 1;
    }

    /**
     * 删 除 操 作
     */
    @Override
    public Boolean del(String id) {
        return testTimeMapper.deleteById(id) == 1;
    }

    /**
     * 修 改 操 作
     */
    @Override
    public Boolean update(TestTime testTime) {
        return testTimeMapper.updateById(testTime) == 1;
    }

    /**
     * 模 糊 查 询 及 分 页
     */
    @Override
    public Page<TestTime> query(Integer pages, String key) {
        Page<TestTime> page = new Page<>(pages, 10);
        QueryWrapper<TestTime> wrapper = new QueryWrapper<>();
        wrapper
                .like("names", key).or()
                .like("id", key);
        testTimeMapper.selectPage(page, wrapper);
        return page;
    }
}