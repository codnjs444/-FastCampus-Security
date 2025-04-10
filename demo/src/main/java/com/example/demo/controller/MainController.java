package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/test")
    public String test() {
        return "✅ 서버 연결 정상!";
    }

    @GetMapping("/user")
    public String user() {
        return "👤 User 전용 페이지";
    }

    @GetMapping("/main")
    public String main() {
        return "🏠 메인 페이지 (USER or ADMIN)";
    }

    @GetMapping("/admin")
    public String admin() {
        return "🛠 관리자 페이지";
    }
}
