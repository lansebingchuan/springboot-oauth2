package com.zht.jwt.controller;

import cn.hutool.core.util.StrUtil;
import com.zht.jwt.business.entity.User;
import com.zht.jwt.business.service.UserService;
import com.zht.jwt.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Api(tags = "用户api")
@RestController
@RequestMapping("/api/user")
public class ApiController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户名查找用户")
    @GetMapping("/getByName")
    public User getByName(String name) {
        return Optional.ofNullable(name).filter(StrUtil::isNotBlank).map(userService::getUser).orElse(me());
    }

    @ApiOperation("获取当前用信息")
    @GetMapping("/me")
    public User me() {
        return SecurityUtils.getUser();
    }
}
