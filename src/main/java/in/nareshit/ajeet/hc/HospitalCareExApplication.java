package in.nareshit.ajeet.hc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HospitalCareExApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HospitalCareExApplication.class, args);
	System.out.println("Bean Definition Count::"+context.getBeanDefinitionCount());
	}

	
}
