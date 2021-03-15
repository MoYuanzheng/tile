package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Packet;
import com.mo.tile.service.impl.PacketServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 大包装追溯码(Packet)表控制层
 *
 * @author MoYz
 * @since 2021-03-15 15:34:37
 */
@Api(tags = "大包装追溯码相关")
@RestController
@RequestMapping("packet")
public class PacketController {
    /**
     * 服务对象
     */
    @Resource
    private PacketServiceImpl packetService;

    @ApiOperation("添 加")
    @PostMapping("add")
    public Boolean add(
            @RequestParam("id") @ApiParam("主键，包裹追溯码") String id,
            @RequestParam("size") @ApiParam("包裹容量") Integer size,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return packetService.add(new Packet(
                id,
                size,
                remark
        ));
    }

    @ApiOperation("批量添加")
    @PostMapping("largeAddition")
    public Boolean largeAddition(
            @RequestParam("number") @ApiParam("数量") Integer number,
            @RequestParam("size") @ApiParam("包裹容量") Integer size
    ) {
        return packetService.largeAddition(number, size);
    }

    @ApiOperation("删 除")
    @DeleteMapping("del")
    public Boolean del(
            @RequestParam("id") @ApiParam("主键") String id
    ) {
        return packetService.del(id);
    }

    @ApiOperation("修 改")
    @PutMapping("update")
    public Boolean update(
            @RequestParam("id") @ApiParam("主键，包裹追溯码") String id,
            @RequestParam("size") @ApiParam("包裹容量") Integer size,
            @RequestParam("remark") @ApiParam("备注") String remark
    ) {
        return packetService.update(new Packet(
                id,
                size,
                remark
        ));
    }

    /**
     * 模 糊 查 询 并 分 页
     */
    @GetMapping("query")
    public Page<Packet> query(
            @RequestParam("pages") @ApiParam("页数") Integer pages,
            @RequestParam("key") @ApiParam("关键词") String key
    ) {
        return packetService.query(pages, key);
    }


}