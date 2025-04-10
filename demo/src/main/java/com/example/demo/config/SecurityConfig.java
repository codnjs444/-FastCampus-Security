package com.example.demo.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Spring Security에서 비밀번호 암호화를 위한 PasswordEncoder를 정의하는 메서드
     * BCryptPasswordEncoder는 비밀번호를 안전하게 암호화하는 데 사용
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring Security의 필터 체인을 구성하는 메서드
     * @param http HttpSecurity 객체
     * @return SecurityFilterChain 객체
     * @throws Exception 예외 발생 시
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/api/test", "/api/login", "/css/**", "/js/**", "/assets/**").permitAll()
                        .requestMatchers("/api/user").hasRole("USER")
                        .requestMatchers("/api/main").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/api/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(auth -> auth
                        .loginPage("/api/login")              // 로그인 페이지 요청 경로 (SSR이 아닌 Vue에서 처리)
                        .loginProcessingUrl("/loginProc")     // 로그인 처리 POST 경로
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.getWriter().write("Unauthorized");
                        })
                );

        return http.build();
    }
}

