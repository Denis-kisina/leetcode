package denis.kisina;

import denis.kisina.config.Conifg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.login.AppConfigurationEntry;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService = context.getBean("emailservice", EmailService.class);
        System.out.println(emailService);
        emailService.sendEmail("denis@test.com", "Hello World");


        ApplicationContext context1 = new AnnotationConfigApplicationContext(Conifg.class);
        EmailService emailService1 = context1.getBean("emailService", EmailService.class);
        System.out.println(emailService1);
        emailService1.sendEmail("denis1@test.com", "Hello world2");

    }
}
