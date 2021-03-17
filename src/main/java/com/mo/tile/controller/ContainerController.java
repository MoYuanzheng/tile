package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Container;
import com.mo.tile.service.impl.ContainerServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Container)表控制层
 *
 * @author MoYz
 * @since 2021-03-15 15:56:26
 */
@Api(tags = "包含相关")
@RestController
@RequestMapping("container")
public class ContainerController {
    /**
     * 服务对象
     */
    @Resource
    private ContainerServiceImpl containerService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("bigId") @ApiParam("大尺寸包装追溯码") String bigId,
            @RequestParam("smallId") @ApiParam("小尺寸追溯码") String smallId,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return containerService.add(new Container(
                bigId,
                smallId,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return containerService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("bigSize") @ApiParam("大尺寸包装追溯码") String bigSize,
            @RequestParam("smallSize") @ApiParam("小尺寸追溯码") String smallSize,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return containerService.update(new Container(
                id,
                bigSize,
                smallSize,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Container> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return containerService.query(pages, key);
    }

    /**
     * 通过大盒子，找到小盒子
     */
    @GetMapping("getSmallIdByBigId")
    public List<String> getSmallIdByBigId(
            @RequestParam("bigId") String bigId
    ) {
        return containerService.getSmallIdByBigId(bigId);
    }
}