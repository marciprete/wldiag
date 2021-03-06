package it.senape.wldiag;

import it.senape.wldiag.service.jpa.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class WlDiagApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlDiagApplication.class, args);
	}
}
