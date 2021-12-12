package com.manager.csv;

import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Setter
@Component
public class CsvReader {
    private final String path = "data.csv";

    @SneakyThrows
    public List<String> read() {
        List<String> array = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream(path);
        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                array.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }


}
