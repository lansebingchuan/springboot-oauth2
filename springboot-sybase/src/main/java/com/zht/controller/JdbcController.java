package com.zht.controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

@Api(value = "Jdbc服务", tags = "Jdbc服务")
@RestController
@RequestMapping("/api/jdbc")
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ApiOperation("执行指定的sql语句")
    @GetMapping("/executeSql")
    private String executeSql(String sql) {
        List<JSONObject> list = new ArrayList<>();
        jdbcTemplate.query(sql, result -> {
            JSONObject object = new JSONObject();
            //获取列集
            ResultSetMetaData metaData = result.getMetaData();
            //获取列的数量
            int columnCount = metaData.getColumnCount();
            //循环列
            for (int i = 0; i < columnCount; i++) {
                //通过序号获取列名,起始值为1
                String columnName = metaData.getColumnName(i+1);
                //通过列名获取值.如果列值为空,columnValue为null,不是字符型
                String columnValue = result.getString(columnName);
                object.put(columnName, columnValue);
                list.add(object);
            }
        });
        return JSONUtil.toJsonStr(list);
    }

}
