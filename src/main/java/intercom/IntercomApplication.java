package intercom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("intercom")
public class IntercomApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntercomApplication.class, args);
	}

}
