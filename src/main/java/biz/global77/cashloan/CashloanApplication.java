package biz.global77.cashloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"biz.global77.cashloan"})
@EnableJpaRepositories(basePackages = {"biz.global77.cashloan.repo"})
@EntityScan(basePackages = {"biz.global77.cashloan.model"})
public class CashloanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashloanApplication.class, args);
	}

}
