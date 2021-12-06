package com.manager.service;

import com.manager.csv.DataEnricher;
import com.manager.domain.Person;
import com.manager.outputService.AppConfiguration;
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

    @Autowired
    public TestSystemImpl(DataEnricher dataEnricher, AppConfiguration appConfiguration) {
        this.dataEnricher = dataEnricher;
        correctAnswers = dataEnricher.getQuestionsAnswersMap();
        this.appConfiguration = appConfiguration;
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
    }
}
