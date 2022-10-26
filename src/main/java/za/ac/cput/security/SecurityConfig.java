package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password(encoder().encode("12345"))
                .roles("ADMIN", "USER");
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(encoder().encode("54321"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.authorizeRequests()

                //employee
                .antMatchers(HttpMethod.POST, "/PharmacySystem/employee/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/employee/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/employee/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/employee/delete/").hasRole("ADMIN")

                //prescription
                .antMatchers(HttpMethod.POST, "/PharmacySystem/prescription/save").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/prescription/read/").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/PharmacySystem/prescription/all").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/PharmacySystem/prescription/delete/").hasRole("ADMIN")

                .and().formLogin()
                .disable()
                .httpBasic();
    }

    @Bean
    public static BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
