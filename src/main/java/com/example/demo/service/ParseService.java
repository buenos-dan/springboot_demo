package com.example.demo.service;

import com.example.demo.repository.TableRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseService {

    public List<List<String>> queryTable(String query) {
        List<List<String>> res = new ArrayList<>();
        List<String> header = TableRepository.getInstance().getHeader();
        List<List<String>> content = TableRepository.getInstance().getContent();


        // TODO: parse query


        return res;
    }
}
