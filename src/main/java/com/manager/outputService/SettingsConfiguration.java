package com.manager.outputService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("classpath:application.properties")
public class SettingsConfiguration {

    @Value("${data.path}")
    private String path;

    @Value("${data.offset}")
    private int offset;

}
