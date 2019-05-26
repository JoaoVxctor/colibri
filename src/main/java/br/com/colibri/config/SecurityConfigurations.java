package br.com.colibri.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan
@EnableWebMvc
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;
    @Value("${spring.queries.usuario-query}")
    private String usuarioQuery;
    @Value("${spring.queries.role-query}")
    private String roleQuery;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;






    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/").hasAuthority("ALUNO")
                .antMatchers("/index").hasAuthority("ALUNO")
                .antMatchers("/login").permitAll()
                .antMatchers("/cadastro").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .authenticated().and()
                .csrf().disable().formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?erro=true")
                .and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("joao@victor").password("admin").authorities("ADMIN","PROFESSOR","USUARIO");

        auth.
                jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(usuarioQuery)
                .authoritiesByUsernameQuery(roleQuery)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
       web
                .ignoring()
                .antMatchers("/resources/**","/static/**","/css/**","/fonts.Roboto/**","/images/**","/js/**" ,"/PSD/**", "/scss/**","/vendors/**");

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
