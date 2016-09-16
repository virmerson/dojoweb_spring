package br.com.fabricadeprogramador.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.userDetailsService( userDetailsService())
		.formLogin()
		
		.defaultSuccessUrl("/index.jsf")
		
		.and()
		
		.csrf()
		
		.disable()
				
		.authorizeRequests()
				
		.antMatchers("/index.jsf")
		
		.permitAll()
		
		.antMatchers("/javax.faces.resource/**")
				
		.permitAll()
		
		.anyRequest()
		
		.authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("javax.faces.resources/*");
	}
	

	@Override
	protected UserDetailsService userDetailsService() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UserDetails> userList = new ArrayList<>();
	
		for (Usuario u: usuarios){
			userList.add(new User( u.getNome() , u.getSenha(),  AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN")  ));
		}
		
		return new InMemoryUserDetailsManager(userList);
	}
}
