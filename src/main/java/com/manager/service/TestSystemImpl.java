package com.manager.service;

import com.manager.csv.DataEnricher;
import com.manager.domain.Person;
import com.manager.outputService.AppConfiguration;
import com.manager.outputService.SettingsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TestSystemImpl implements TestSystem {
    private final DataEnricher dataEnricher;
    private final Map<String, Integer> correctAnswers;
    private final AppConfiguration appConfiguration;
    private Map<String, Integer> map;
    private int amountOfCorrectAnswers;
    private final int offset;

    @Autowired
    public TestSystemImpl(DataEnricher dataEnricher, AppConfiguration appConfiguration, SettingsConfiguration settingsConfiguration) {
        this.dataEnricher = dataEnricher;
        correctAnswers = dataEnricher.getQuestionsAnswersMap();
        this.appConfiguration = appConfiguration;
        this.offset = settingsConfiguration.getOffset();
    }

    @Override
    public void test(Person person) {
        map = person.getAnswer();
        List<String> questions = new ArrayList<>(map.keySet());
        for (String question : questions) {
            if (Objects.equals(map.get(question), correctAnswers.get(question))) {
                amountOfCorrectAnswers++;
            }
        }

        System.out.println(person.getName() + " " + person.getSurname() + appConfiguration.getMessage("presenter.conclusion-first") + amountOfCorrectAnswers + " " + appConfiguration.getMessage("presenter.conclusion-second") + map.size());
        if (amountOfCorrectAnswers >= offset) {
            System.out.println(appConfiguration.getMessage("presenter.pass-offset"));
        } else {
            System.out.println(appConfiguration.getMessage("presenter.failed-offset"));
        }
    }
}
