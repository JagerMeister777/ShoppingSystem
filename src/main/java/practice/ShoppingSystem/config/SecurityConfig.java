package practice.ShoppingSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // すべてのリクエストを許可
        .csrf(csrf -> csrf.disable()) // CSRF保護を無効化
        .formLogin(AbstractHttpConfigurer::disable) // フォームログインを無効化
        .httpBasic(AbstractHttpConfigurer::disable); // HTTP Basic認証を無効化
    return http.build();
  }

}
