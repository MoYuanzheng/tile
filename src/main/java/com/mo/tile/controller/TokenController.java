package com.mo.tile.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.tile.entity.Token;
import com.mo.tile.service.impl.TokenServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * (Token)表控制层
 *
 * @author mo
 * @since 2021-01-23 15:22:38
 */
@RestController
@RequestMapping("token")
public class TokenController {
    /**
     * 服务对象
     */
    @Resource
    private TokenServiceImpl tokenService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Token selectOne(String id) {
        return tokenService.getById(id);
    }
    
    /**
     * 分 页 查 询
     */
    @ResponseBody
    @GetMapping("table")
    public Page<Token> page(@RequestParam("pages") Integer pages) {
        return tokenService.selectPage(pages);
    }
}