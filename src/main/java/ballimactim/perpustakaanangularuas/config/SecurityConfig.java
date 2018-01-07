/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballimactim.perpustakaanangularuas.config;

import ballimactim.perpustakaanangularuas.config.controller.entity.repo.util.CsrfHeaderFilter;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


/**
 *
 * @author AguzR
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource ds;
    
    private String qryUser = 
            "select username, password, enabled " + 
            "from users " +
            "where username = ?";
    
    private String qryRole = 
            "select u.username, r.role " +
            "from users u " + 
            "join user_role ur on (ur.username = u.username) " +
            "join roles r on (r.id = ur.id_role) " + 
            "where u.username =?";
   
    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth)
            throws Exception {
        
        auth.jdbcAuthentication()
                .dataSource(ds)
                .usersByUsernameQuery(qryUser)
                .authoritiesByUsernameQuery(qryRole);
                
    }
    
    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http
             .authorizeRequests()

             .antMatchers("/js/**").permitAll()
             .antMatchers("/bootstrap/**").permitAll()
             .anyRequest().authenticated()
            .and()
             .formLogin().permitAll()
            .and()
             .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
             .csrf().csrfTokenRepository(csrfTokenRepository());
        
    }
    
    private CsrfTokenRepository csrfTokenRepository(){
        HttpSessionCsrfTokenRepository tokenRepo = new HttpSessionCsrfTokenRepository();
        tokenRepo.setHeaderName("X-XSRF-TOKEN");
        return tokenRepo;
    }

}
