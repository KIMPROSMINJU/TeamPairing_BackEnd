package kr.ac.kopo.minju_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MinjuBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinjuBackendApplication.class, args);
	}

}
