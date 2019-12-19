package hu.zsoltii.springboot.aspectj.example;

import hu.zsoltii.springboot.aspectj.example.business.Business1;
import hu.zsoltii.springboot.aspectj.example.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hu.zsoltii.springboot.aspectj.example.config"})
public class SpringBootAspectjProxyExampleApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAspectjProxyExampleApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringBootAspectjProxyExampleApplication.class, args);

		Business1 business1 = context.getBean(Business1.class);
		Business2 business2 = context.getBean(Business2.class);

		LOGGER.info(business1.calculateSomething());
		LOGGER.info(business2.calculateSomething());

		System.exit(0);
	}


}
