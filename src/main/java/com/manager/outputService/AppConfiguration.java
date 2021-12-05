package com.manager.outputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AppConfiguration {

    private final MessageSource messageSource;
    private final Locale locale;

    @Autowired
    public AppConfiguration(@Value("#{ systemProperties['user.language'] + '_' + systemProperties['user.country']}") Locale locale, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public String getMessage(String code) {
        return messageSource.getMessage(code, new String[] {"Ivan"}, locale);//en_EN  new Locale("en", "EN") //todo: разобраться с аргс
    }
}
