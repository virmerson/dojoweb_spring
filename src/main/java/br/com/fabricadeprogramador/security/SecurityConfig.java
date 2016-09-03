package br.com.fabricadeprogramador.security;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
          .userDetailsService(userDetailsService())
          .formLogin()
            .defaultSuccessUrl("/index.jsf").and()
          .csrf()
            .disable()
          .authorizeRequests()
            .antMatchers("/index.jsf").permitAll()
            .antMatchers("/javax.faces.resource/**").permitAll()
            .anyRequest().authenticated();
   }

   @Override
   public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("javax.faces.resources/*");
   }

   @Override
   protected UserDetailsService userDetailsService() {
      UserDetails user1 = new User("jao", "123", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
      UserDetails user2 = new User("ze", "456", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
      return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));
   }
}
