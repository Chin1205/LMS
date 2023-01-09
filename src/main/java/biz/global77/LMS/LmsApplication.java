package biz.global77.LMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"biz.global77.LMS"}, exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories(basePackages = {"biz.global77.LMS.repo"})
@EntityScan(basePackages = {"biz.glob77.LMS.model"})
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

}
