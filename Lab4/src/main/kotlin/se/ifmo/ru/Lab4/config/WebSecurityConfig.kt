package se.ifmo.ru.Lab4.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import javax.sql.DataSource
import kotlin.jvm.Throws


@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter(){

    @Autowired
    private lateinit var dataSource: DataSource
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                    .antMatchers("/", "/login").permitAll()
                    .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                     .permitAll()
                .and()
                    .logout()
                    .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.jdbcAuthentication()
                ?.dataSource(dataSource)
                ?.passwordEncoder(NoOpPasswordEncoder.getInstance())
                ?.usersByUsernameQuery("select username, password, active from usr where username=?")
                ?.authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?")
    }
}