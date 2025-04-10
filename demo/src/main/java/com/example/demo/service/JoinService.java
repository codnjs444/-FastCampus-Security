package com.example.demo.service;

import com.example.demo.dto.JoinDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void join(JoinDTO joinDTO) {

        Boolean isExist = userRepository.existsByUsername(joinDTO.getUsername());
        if (isExist) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        UserEntity entity = new UserEntity();
        entity.setUsername(joinDTO.getUsername());
        entity.setPassword(passwordEncoder.encode(joinDTO.getPassword()));
        entity.setRole("ROLE_ADMIN");

        userRepository.save(entity);
    }
}
