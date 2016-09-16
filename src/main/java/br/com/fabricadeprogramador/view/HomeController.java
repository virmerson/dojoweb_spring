package br.com.fabricadeprogramador.view;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
@ViewScoped
public class HomeController {

	public String getUserName(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		}
		return "";
	}
}
