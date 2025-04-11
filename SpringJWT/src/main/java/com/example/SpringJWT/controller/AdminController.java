package com.example.SpringJWT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api")
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "🛠 관리자 페이지";
    }
}
