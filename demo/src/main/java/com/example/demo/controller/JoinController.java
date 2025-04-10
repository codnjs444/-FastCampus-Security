package com.example.demo.controller;

import com.example.demo.dto.JoinDTO;
import com.example.demo.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JoinController {

    @Autowired
    private JoinService joinService;
//
    @PostMapping("/join")
    public String join(@RequestBody JoinDTO joinDTO) {
        System.out.println("joinDTO = " + joinDTO.getUsername());
        joinService.join(joinDTO);

        return "회원가입 완료";
    }


}
