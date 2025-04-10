package com.example.demo.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index.html", "/api/test", "/api/login", "/api/join").permitAll()
                        .requestMatchers("/api/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // 🔐 인증되지 않은 사용자가 보호된 자원에 접근했을 때 안내할 로그인 페이지 경로 (프론트엔드 전용 페이지)
                        .loginPage("/api/login")

                        // 📨 실제 로그인 인증 처리를 담당할 POST 요청 경로
                        // 사용자는 이 경로로 아이디/비밀번호를 전송함
                        .loginProcessingUrl("/api/login")

                        // ✅ 로그인 성공 시 동작 정의
                        // 기본 redirect 없이 상태 코드 200만 반환하여 프론트(Vue)가 직접 라우팅 처리하도록 함
                        .successHandler((request, response, authentication) -> {
                            response.setStatus(HttpServletResponse.SC_OK); // HTTP 200 OK
                        })

                        // ❌ 로그인 실패 시 동작 정의
                        // redirect 대신 HTTP 401 응답을 주어 프론트에서 실패 메시지를 보여줄 수 있게 함
                        .failureHandler((request, response, exception) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // HTTP 401 Unauthorized
                        })

                        // 🌐 누구나 로그인 페이지와 로그인 요청에 접근 가능하도록 허용
                        .permitAll()
                )



                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                        })
                );
        return http.build();
    }
}

