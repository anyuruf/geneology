package net.anyuruf.geneology.familyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FamilyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyServiceApplication.class, args);
	}

}
