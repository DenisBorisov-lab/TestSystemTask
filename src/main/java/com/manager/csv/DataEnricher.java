package com.manager.csv;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataEnricher {
    private final Map<String, Integer> questionsAnswersMap = new HashMap<>();
    private final List<String> questions = new ArrayList<>();
    private final CsvReader reader;

    public DataEnricher(CsvReader reader) {
        this.reader = reader;
        enrichData();
    }

    public Map<String, Integer> getQuestionsAnswersMap() {
        return questionsAnswersMap;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void enrichData() {//enrich
        List<String> read = reader.read();
        for (String task : read) {
            String[] split = task.split(",");
            questions.add(split[0]);

            questionsAnswersMap.put(split[0], Integer.parseInt(split[1]));
        }
    }
}
