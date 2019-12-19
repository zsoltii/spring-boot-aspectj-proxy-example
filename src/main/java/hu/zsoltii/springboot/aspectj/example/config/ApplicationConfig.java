package hu.zsoltii.springboot.aspectj.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"hu.zsoltii.springboot.aspectj.example.config.aspect", "hu.zsoltii.springboot.aspectj.example.business", "hu.zsoltii.springboot.aspectj.example.data"})
public class ApplicationConfig {
}
