package com.manager;


import com.manager.csv.CsvReader;
import com.manager.csv.DataEnricher;
import com.manager.service.Appearance;
import com.manager.service.TestSystem;
import com.manager.service.TestSystemImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);
        Demo bean = context.getBean(Demo.class);
        TestSystem system = new TestSystemImpl(bean.appearance().getPerson(), bean.dataEnricher());
        system.test();
    }

    @Bean
    public Appearance appearance() {
        return new Appearance(dataEnricher());
    }

    @Bean
    public DataEnricher dataEnricher() {
        return new DataEnricher(csvReader());
    }

    @Bean
    public CsvReader csvReader() {
        return new CsvReader();
    }
}
