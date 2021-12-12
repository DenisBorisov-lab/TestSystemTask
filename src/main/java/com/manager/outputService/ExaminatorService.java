package com.manager.outputService;

import com.manager.csv.DataEnricher;
import com.manager.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
public class ExaminatorService {
    private final Map<String, Integer> map;
    private final List<String> questions;
    private final AppConfiguration appConfiguration;
    private Person person;

    @Autowired
    public ExaminatorService(DataEnricher dataEnricher, AppConfiguration appConfiguration) {
        questions = dataEnricher.getQuestions();
        map = new HashMap<>();
        this.appConfiguration = appConfiguration;
        person = ask();
    }

    private Person ask() {
        Scanner sc = new Scanner(System.in);
        System.out.print(appConfiguration.getMessage("presenter.name"));
        String name = sc.nextLine();
        System.out.print(appConfiguration.getMessage("presenter.surname"));
        String surname = sc.nextLine();
        for (String question : questions) {
            System.out.println(appConfiguration.getMessage("presenter.question") + question);
            System.out.print(appConfiguration.getMessage("presenter.answer"));
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
