package com.example.SpringJWT.controller;

import com.example.SpringJWT.dto.JoinDTO;

import com.example.SpringJWT.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String join(@RequestBody JoinDTO joinDTO) {
        joinService.join(joinDTO);
        return "회원가입 완료";
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginPage() {
        return ResponseEntity.ok("🔐 프론트엔드 로그인 페이지 경로");
    }
}
