package com.cho1r;

import com.cho1r.service.LogPrint;
import com.cho1r.service.MailService;
import com.cho1r.service.User;
import com.cho1r.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration
@ComponentScan
@PropertySource("app.properties")// 针对ioc容器, 所有bean都可读取
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    @Profile("!test")
    String db() {
        return "mysql";
    }

    @Bean
    @Profile("test")
    String dbForTest() {
        return "list";
    }

//    @Value("${app.name:Z}")
//    private String name;
//
//    @Bean
//    @Qualifier("printName")
//    String printName() {
//        return name;
//    }

    @Bean
    @Qualifier("z")
    @Primary
    ZoneId createZoneOfZ() {
        return ZoneId.of("Z");
    }

    //    @Bean
//    @Qualifier("utc8")
    // or
    @Bean("utc8")
    ZoneId createZoneOfUTC8() {
        return ZoneId.of("UTC+08:00");
    }


    //	@SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        LogPrint logPrint = context.getBean(LogPrint.class);
//        logPrint.logPrint();

//        System.out.println(context.getBean("printName"));

//        context.getBean(MailService.class).f1();

//        System.out.println(context.getBean(String.class));

		UserService userService = context.getBean(UserService.class);
		User user = userService.login("bob@example.com", "password");
//		System.out.println(user.getName());

//        System.out.println(context.getBean(ZoneId.class));

//        MailService mailService = context.getBean(MailService.class);
//        System.out.println(mailService.zoneId);
//        context.close();

//        ZoneId o1 = context.getBean(ZoneIdFactoryBean.class).getObject();
//        ZoneId o2 = context.getBean(ZoneIdFactoryBean.class).getObject();

//        System.out.println(o1 == o2);// true

//        System.out.println(o2);


    }
}
