package lk.ijse.dep.main;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = "lk")
@Import(HibernateConfig.class)
public class AppConfig {
}
