package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    /**
     * Vue에서 사용하는 커스텀 로그인 페이지를 위해
     * Spring Security에 존재한다고 알려주는 역할만 함.
     * 실제 로그인 화면은 프론트(Vue)가 담당.
     */
    @GetMapping("/login")
    public ResponseEntity<String> loginPage() {
        return ResponseEntity.ok("🔐 프론트엔드 로그인 페이지 경로");
    }
}
