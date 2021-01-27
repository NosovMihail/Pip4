package se.ifmo.ru.Lab4.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import kotlin.jvm.Throws


@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter(){
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                     .permitAll()
                .and()
                    .logout()
                    .permitAll()
    }

}