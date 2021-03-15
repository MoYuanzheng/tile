package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.PacketStatistics;
import com.mo.tile.service.impl.PacketStatisticsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 包装盒数量统计(PacketStatistics)表控制层
 *
 * @author MoYz
 * @since 2021-03-15 16:56:54
 */
@Api(tags = "包装盒数量统计相关")
@RestController
@RequestMapping("packetStatistics")
public class PacketStatisticsController {
    /**
     * 服务对象
     */
    @Resource
    private PacketStatisticsServiceImpl packetStatisticsService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("size") @ApiParam("容量") Integer size,
            @RequestParam("surplus") @ApiParam("剩余数量") Integer surplus,
            @RequestParam("total") @ApiParam("总共生产") Integer total,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return packetStatisticsService.add(new PacketStatistics(
                id,
                size,
                surplus,
                total,
                remark
        ));
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return packetStatisticsService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键") String id,
            @RequestParam("size") @ApiParam("容量") Integer size,
            @RequestParam("surplus") @ApiParam("剩余数量") Integer surplus,
            @RequestParam("total") @ApiParam("总共生产") Integer total,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return packetStatisticsService.update(new PacketStatistics(
                id,
                size,
                surplus,
                total,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<PacketStatistics> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return packetStatisticsService.query(pages, key);
    }
}