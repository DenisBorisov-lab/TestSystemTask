package com.manager.domain;

import java.util.Map;

public class Person {
    private final String name;
    private final String surname;
    private final Map<String, Integer> answer;

    public Person(String name, String surname, Map<String, Integer> answer) {
        this.name = name;
        this.surname = surname;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Map<String, Integer> getAnswer() {
        return answer;
    }
}
