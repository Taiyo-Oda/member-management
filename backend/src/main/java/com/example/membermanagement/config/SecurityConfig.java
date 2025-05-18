package com.example.membermanagement.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

  @Value("${cors.allowed-origins}")
  private String allowedOrigins;

  // 本番環境用のセキュリティ設定
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .headers(
            headers ->
                headers.frameOptions(
                    HeadersConfigurer.FrameOptionsConfig
                        ::deny)) // X-FRAME-OPTIONS: DENY（ページがどのフレームにも表示されることを禁止する） を設定
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    return httpSecurity.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of(allowedOrigins.split(",")));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(List.of("Authorization", "Content-Type")); // 必要なヘッダーのみ許可
    configuration.setAllowCredentials(true); // withCredentialsを有効に（CORSリクエストがクッキーや認証情報を含むことを許可）する
    configuration.setMaxAge(3600L); // プリフライトリクエストのキャッシュ時間を設定（１時間）し、同じオリジンに対する複数のリクエストでプリフライトの繰り返し防ぐ

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
