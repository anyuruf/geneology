package net.anyuruf.geneology.gatewayservice.config;

import java.util.Arrays;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.scalars.ExtendedScalars;
import net.anyuruf.geneology.gatewayservice.WebClient.XWebClient;

@Configuration
public class GraphQlConfig {
	@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
		return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date);
	}

	@Bean
	@LoadBalanced
	WebClient webClient(ObjectMapper objectMapper) {
		return WebClient.builder().baseUrl("http://fedora:8020/graphql").build();
	}

	@Bean
	XWebClient xWebClient(WebClient webClient) {
		HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(webClient)).build();

		return httpServiceProxyFactory.createClient(XWebClient.class);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
