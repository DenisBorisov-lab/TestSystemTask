package com.manager.outputService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class SettingsConfiguration {

    @Value("${data.path}")
    private static String path;

    public static void main(String[] args) {
        System.out.println(path);
    }
}
