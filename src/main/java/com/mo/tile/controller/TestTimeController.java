package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.TestTime;
import com.mo.tile.service.impl.TestTimeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TestTime)表控制层
 *
 * @author MoYz
 * @since 2021-02-09 15:00:41
 */
@RestController
@RequestMapping("testTime")
public class TestTimeController {
    /**
     * 服务对象
     */
    @Resource
    private TestTimeServiceImpl testTimeService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("names") String names,
            @RequestParam("id") String id
    ) {
        return testTimeService.update(new TestTime(
                names,
                id
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("账号") String id
    ) {
        return testTimeService.del(id);
    }

    @ApiOperation("修 改")
    @PostMapping("update")
    public Boolean update(
            @RequestParam("names") String names,
            @RequestParam("id") String id
    ) {
        return testTimeService.update(new TestTime(
                names,
                id
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<TestTime> query(
            @RequestParam("pages") Integer pages,
            @RequestParam("key") String key
    ) {
        return testTimeService.query(pages, key);
    }
}