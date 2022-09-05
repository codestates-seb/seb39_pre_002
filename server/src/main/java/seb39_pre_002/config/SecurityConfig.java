package seb39_pre_002.config;

//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.web.filter.CorsFilter;
//import seb39_pre_002.config.oauth.PrincipalOauth2UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import seb39_pre_002.member.repository.MemberRepository;

//@Configuration
//@EnableWebSecurity(debug = true) //변신 이거때문에 시큐리티댐 @Configuration에 이미 있음? 확인필요
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//public class SecurityConfig {
//
//    @Autowired
//    private CorsFilter corsFilter;
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired //의존성 주입 생성자 주입이 좀 더 좋긴함 필드로 의존성 주입
//    private PrincipalOauth2UserService principalOauth2UserService;
//
////    @Bean //암호화
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().disable();
//        http.csrf().disable(); //포스트맨 안되는 이유?
//        http.headers().frameOptions().disable();
//
////        http.addFilterAfter(new FirstFilter(), LogoutFilter.class);
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(corsFilter) // 추가
//                .formLogin().disable()
//                .httpBasic().disable()
//                .apply(new CustomDsl()) // 추가
//                .and()
//                .authorizeRequests()
////        http.authorizeRequests()
//                .antMatchers("/user/**").authenticated()
//                .antMatchers("/manager/**")
//                .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
//                .antMatchers("/admin/**")
//                .access("hasRole('ROLE_ADMIN')")
//                .anyRequest().permitAll()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .loginProcessingUrl("/login") // login url이 호출되면 시큐리티가 대신 로그인을 진행한다.
////                .defaultSuccessUrl("/")
//                .and()
//                .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint()
//                .userService(principalOauth2UserService); //여기서 로직 수행 연결점.
//        return http.build();
//    }
//}
//
//public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {
//
//    @Override
//    public void configure(HttpSecurity builder) throws Exception {
//        AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
//        builder
//                .addFilter(corsFilter)
//                .addFilter(new JwtAuthenticationFilter(authenticationManager))
//                .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository));

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;
import seb39_pre_002.member.repository.MemberRepository;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor // 추가
public class SecurityConfig {

    private final CorsFilter corsFilter;
    private final MemberRepository memberRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class); // 추가 필터 전후로 적용
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .addFilter(corsFilter) // 추가
                .formLogin().disable()
                .httpBasic().disable()
                .apply(new CustomDsl()) // 추가2
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/user/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/v1/manager/**")
                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/api/v1/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();

        return http.build();
    }
    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder
                    .addFilter(corsFilter)
                    .addFilter(new seb39_pre_002.Filter.JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new seb39_pre_002.Filter.JwtAuthorizationFilter(authenticationManager, memberRepository));
            //memberRepository 오류 인가에 있어서? 생성자의 2번째 매개변수로 추가 설정함
            //오류 떠서 인가에 있는 memberRepository this.m = this.m 에서 뒤에꺼 디스 삭제
        }
    }

}
