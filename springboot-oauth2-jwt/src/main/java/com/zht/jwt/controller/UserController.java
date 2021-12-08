package com.zht.jwt.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zht.jwt.business.entity.User;
import com.zht.jwt.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 用户控制器
 */
@Api(value = "用户控制器", tags = "用户控制器")
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 定义用户信息
     *
     * @param authentication
     * @return
     */
    @ApiOperation("获取当前用信息（方式一）")
    @PreAuthorize("hasAuthority('read')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getUser(UsernamePasswordAuthenticationToken authentication) {
        User user = (User) authentication.getPrincipal();
        return new ResponseEntity<>(new HashMap<String, Object>() {{
            put("name", user.getName());
            put("username", user.getUsername());
            put("id", user.getId());
            put("createAt", user.getCreateTime());
            put("auth", user.getAuthorities());
        }}, HttpStatus.OK);
    }


    /**
     * 定义用户信息
     *
     * @return
     */
    @ApiOperation("获取当前用信息（方式二）")
    @PreAuthorize("hasAuthority('read')")
    @RequestMapping(value = "/user-2", method = RequestMethod.GET)
    public ResponseEntity<User> getUser2() {
        User user = SecurityUtils.getUser();
        if (ObjectUtil.isNotEmpty(user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }


    /**
     * 定义用户信息
     *
     * @return
     */
    @ApiOperation("获取当前用户名称")
    @PreAuthorize("hasAuthority('get')")
    @GetMapping(value = "/getName")
    public ResponseEntity<String> getName() {
        return new ResponseEntity<>("张海涛", HttpStatus.OK);
    }


}
