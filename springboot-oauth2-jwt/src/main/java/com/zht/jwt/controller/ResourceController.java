package com.zht.jwt.controller;

import com.zht.jwt.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource")
public class ResourceController {

    @GetMapping("/getResource")
    public ResponseEntity<String> getResource() {
        // 访问资源之前进行用户身份验证（jwt验证）
        JwtUtil.parseToken("eyJhbGciOiJIUzUxMiJ9.eyJuYW1lIjoi5byg5rW35rabIn0.KVA22lCufkGCa0eBVmuTljgcw_kOnANkEDurU79bNDE6gfeoWfEycyCnA5s0NceRonJhZxSlktlz8kZ0826JnA");
        return new ResponseEntity<>("Resource", HttpStatus.OK);
    }

}
