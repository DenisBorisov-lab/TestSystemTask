package com.manager;


import com.manager.outputService.ExaminatorService;
import com.manager.service.TestSystem;
import com.manager.service.TestSystemImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);
        TestSystem bean = context.getBean(TestSystemImpl.class);
        ExaminatorService appearance = context.getBean(ExaminatorService.class);
        bean.test(appearance.getPerson());
    }
}
