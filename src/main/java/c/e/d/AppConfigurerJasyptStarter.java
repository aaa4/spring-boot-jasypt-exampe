package c.e.d;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "encrypted.properties")
public class AppConfigurerJasyptStarter {
}