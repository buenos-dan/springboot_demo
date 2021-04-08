package com.example.demo.repository;

import com.csvreader.CsvReader;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableRepository {
    private static TableRepository instance = new TableRepository();
    private List<String> header =  new ArrayList<>();
    private List<List<String>> content = new ArrayList<>();

    private TableRepository(){
        try {
            loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() throws IOException {

        CsvReader csvReader = new CsvReader(
                "/Users/buenos/Downloads/demo/src/main/resources/assets/test.csv",
                ',',
                Charset.forName("UTF-8"));

//        csvReader.readHeaders();
//        System.out.println(csvReader.get(0));

        // get header
        csvReader.readRecord();
        header.addAll(Arrays.asList(csvReader.get(0).split(" ")));

        // 读取每行的内容
        while (csvReader.readRecord()) {
            List<String> row = new ArrayList<>();
            row.addAll(Arrays.asList(csvReader.get(0).split(" ")));
            content.add(row);
        }
    }

    public static TableRepository getInstance() {
        return instance;
    }

    public List<String> getHeader() {
        return header;
    }

    public List<List<String>> getContent() {
        return content;
    }
}
