//package seb39_pre_002.config;
//
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SecurityConfig {
//
//    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//////        return http
//////                .authorizeHttpRequests(auth -> auth
//////                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//////                        .mvcMatchers(
//////                                HttpMethod.GET,
//////                                "/",
//////                                "/articles",
//////                                "/articles/search-hashtag"
//////                        ).permitAll()
//////                        .anyRequest().authenticated()
//////                )
//////                .formLogin().and()
//////                .logout()
//////                .logoutSuccessUrl("/")
//////                .and()
//////                .build();
//////    }
//////
//////    @Bean
//////    public UserDetailsService userDetailsService(memberRepository memberRepository) {
//////        return username -> userAccountRepository
//////                .findById(username)
//////                .map(memberDto::from)
//////                .map(BoardPrincipal::from)
//////                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username));
//////    }
//////
//////    @Bean
//////    public PasswordEncoder passwordEncoder() {
//////        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//////    }
////
////}

package seb39_pre_002.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;
import seb39_pre_002.filter.FirstFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final CorsFilter corsFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class);
        //addFilterBefore() 또는 addFilterAfter()를 사용해서 특정 필터 전/후로 적용될 수 있게 함.
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter)
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/api/users/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/manager/**")
                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();
        return http.build();
    }
}