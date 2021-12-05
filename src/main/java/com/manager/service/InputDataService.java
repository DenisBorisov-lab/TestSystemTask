package com.manager.service;

import com.manager.csv.DataEnricher;
import com.manager.domain.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class InputDataService {
    private Person person;
    private final Map<String, Integer> map;
    private final List<String> questions;

    public InputDataService(DataEnricher dataEnricher) {
        questions = dataEnricher.getQuestions();
        map = new HashMap<>();
        person = ask();
    }

    private Person ask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = sc.nextLine();
        System.out.print("Введите вашу фамилию: ");
        String surname = sc.nextLine();
        for (String question : questions) {
            System.out.println("Вопрос: " + question);
            System.out.print("Ответ: ");
            int answer = sc.nextInt();
            map.put(question, answer);
        }
        person = new Person(name, surname, map);
        return person;
    }


    public Person getPerson() {
        return person;
    }
}
