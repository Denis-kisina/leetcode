package denis.kisina.config;

import denis.kisina.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conifg {

    @Bean
    public EmailService emailService(){
        return new EmailService();
    }
}
