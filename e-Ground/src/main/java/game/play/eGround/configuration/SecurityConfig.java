//package game.play.eGround.configuration;
////
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//public class SecurityConfig {
//
//   @Bean
//   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	   
//		// Enable CORS and disable CSRF
//		http = http.cors().and().csrf().disable();
//
//		// Set session management to stateless
//		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
//
//		// Set unauthorized requests exception handler
//		http = http.exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
//			ex.printStackTrace();
//			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
//		}).and();
//
//		// Set permissions on endpoints
//		http.authorizeRequests(authz -> authz.antMatchers("/", "/actuator/**").permitAll()
////				.antMatchers("/student/*").permitAll()
//				.anyRequest().authenticated()).oauth2ResourceServer().jwt()
//				.jwtAuthenticationConverter(jwtAuthenticationConverter());
//
//		return http.build();
//	   
//   }
//   
//   
//   private JwtAuthenticationConverter jwtAuthenticationConverter() {
////		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
////		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
////		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
//		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//		jwtAuthenticationConverter.setPrincipalClaimName("preferred_username");
//		//jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//		return jwtAuthenticationConverter;
//	}
//	
//}
//
//
//
