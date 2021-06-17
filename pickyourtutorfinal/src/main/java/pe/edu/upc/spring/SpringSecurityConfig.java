package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.auth.handler.LoginSucessHandler;
import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JpaUserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private LoginSucessHandler sucessHandler;

	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
					.antMatchers("/tutor/**").access("hasRole('ROLE_TUTOR')")
					.antMatchers("/cliente/**").access("hasRole('ROLE_CLIENTE')")
					.antMatchers("/curso/**").access("hasRole('ROLE_TUTOR')")
					.antMatchers("/pago/**").access("hasRole('ROLE_CLIENTE')")
					.antMatchers("/cursotutor/**").access("hasRole('ROLE_TUTOR')")
					.antMatchers("/metodopago/**").access("hasRole('ROLE_CLIENTE')")
					.antMatchers("/resenatutor/**").access("hasRole('ROLE_CLIENTE')")
					.antMatchers("/solicitudclase/**").access("hasRole('ROLE_CLIENTE')")					
					
					.antMatchers("/welcome/**").access("hasRole('ROLE_TUTOR') or hasRole('ROLE_CLIENTE')").and().formLogin()
					
					.successHandler(sucessHandler).loginPage("/login").loginProcessingUrl("/login")
					.defaultSuccessUrl("/welcome/bienvenido").permitAll().and().logout().logoutSuccessUrl("/login")
					.permitAll().and().exceptionHandling().accessDeniedPage("/error_403");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
