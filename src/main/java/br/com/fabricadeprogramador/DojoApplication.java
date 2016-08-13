package br.com.fabricadeprogramador;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

/**
 * @author Virmerson
 *
 *        
 */

@SpringBootApplication
public class DojoApplication implements ServletContextAware {
	private static Log logger = LogFactory.getLog(DojoApplication.class);

	public DojoApplication() {
		logger.debug("Iniciando aplicação");
	}

	public static void main(String[] args) {
		SpringApplication.run(DojoApplication.class);
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		//Registre o Servlet do JSF para responder .XHTML e .JSF
		ServletRegistrationBean registration = new ServletRegistrationBean(new FacesServlet(), "*.xhtml", "*.jsf");
		registration.setLoadOnStartup(1);
		return registration;
	}
	
	/** Para fazermos funcionar Spring Boot sem web.xml ou faces-config.xml
	 *         precisamos forçar o carregamento load do arquivo de configuracoa via
	 *         init parameter no ServletContext. Um jeito facil é implementar a
	 *         interface ServletContextAware: **/

	@Override
	public void setServletContext(ServletContext servletContext) {
		//Configure Automático
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	}

}