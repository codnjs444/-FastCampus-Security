package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/test")
    public String test() {
        return "✅ 서버 연결 정상!";
    }

    @GetMapping("/user")
    public String user() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();
        return "👤 User 전용 페이지";
    }

    @GetMapping("/main")
    public String main() {
        return "🏠 메인 페이지 (USER or ADMIN)";
    }

    @GetMapping("/admin")
    public String admin() {
        // 현재 로그인한 사용자 ID (username)
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("✅ 로그인한 사용자 ID: " + id);

        // Authentication 객체에서 권한 추출
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            System.out.println("✅ 권한: " + authority.getAuthority());
        }

        return "🛠 관리자 페이지";
    }

}
