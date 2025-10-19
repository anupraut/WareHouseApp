package in.nareshit.raghu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http.authorizeRequests()
                .requestMatchers("/user/showLogin", "/user/showForgotPwd", "/user/updateForgotPwd").permitAll()
                .requestMatchers("/user/showActivateByOtp", "/user/activate").permitAll()
                .requestMatchers("/user/**").hasAuthority("ADMIN")
                .requestMatchers("/uom/**", "/om/**", "/st/**", "/wh/**", "/part/**").hasAnyAuthority("ADMIN", "APPUSER")
                .requestMatchers("/po/**", "/grn/**", "/so/**", "/ship/**").hasAuthority("APPUSER")
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/user/showLogin") //to show login page
                .loginProcessingUrl("/login") //to validate un,pwd
                .defaultSuccessUrl("/user/setup", true) //login success
                .failureUrl("/user/showLogin?error") //login failed

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //logout URL
                .logoutSuccessUrl("/user/showLogin?success") //logout success


        ;
        return http.build();
    }
}
