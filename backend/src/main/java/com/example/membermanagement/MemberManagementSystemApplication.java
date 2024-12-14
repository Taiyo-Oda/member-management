package com.example.membermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class MemberManagementSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(MemberManagementSystemApplication.class, args);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        auth ->
            auth.requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**")
                .permitAll() // ルートと/homeは認証不要
                .anyRequest()
                .authenticated() // その他のパスは認証が必要
        );

    return http.build();
  }
}
