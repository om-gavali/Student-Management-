package Main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import Main.service.MyUserSetailsService;

@Configuration
@EnableWebSecurity
public class userConfig {
	
	@Autowired
	MyUserSetailsService userSetailsService;

	    @Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http)
		{
			return http
	                .csrf(csrf -> csrf.disable())
	               
	                .authorizeHttpRequests(auth -> auth
	                        .requestMatchers("/login", "/register", "/saveUser", "/css/**").permitAll()
	                        .anyRequest().authenticated()
	                )

	                .formLogin(form -> form
	                        .loginPage("/login")
	                        .defaultSuccessUrl("/dashboard", true)
	                        .permitAll()
	                )
	                .logout(logout -> logout
	                        .logoutSuccessUrl("/login?logout")
	                )
	                .build();
		}
		
		@Bean
		public AuthenticationProvider provider1()
		{
			DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userSetailsService);
			
			 provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
			 return provider;
			
							
		}
}
