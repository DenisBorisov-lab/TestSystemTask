package com.manager.service;

import com.manager.csv.DataEnricher;
import com.manager.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestSystemImpl implements TestSystem {
    private Map<String, Integer> map;
    private int amountOfCorrectAnswers;
    private DataEnricher dataEnricher;
    private Map<String, Integer> correctAnswers;
    private Person person;

    public TestSystemImpl(Person person, DataEnricher dataEnricher) {
        this.person = person;
        this.dataEnricher = dataEnricher;
        correctAnswers = dataEnricher.getQuestionsAnswersMap();
    }

    @Override
    public void test() {
        map = person.getAnswer();
        List<String> questions = new ArrayList<>(map.keySet());
        for (String question : questions) {
            if (Objects.equals(map.get(question), correctAnswers.get(question))) {
                amountOfCorrectAnswers++;
            }
        }

        System.out.println(person.getName() + " " + person.getSurname() + ", Вы ответили на " + amountOfCorrectAnswers + " из " + map.size());
    }
}
