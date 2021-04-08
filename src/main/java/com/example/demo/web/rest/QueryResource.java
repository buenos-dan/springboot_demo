package com.example.demo.web.rest;

import com.example.demo.service.ParseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryResource {
    private  final ParseService parseService;

    public QueryResource(ParseService parseService) {
        this.parseService = parseService;
    }

    @GetMapping()
    public ResponseEntity<List<List<String>>> hello(@RequestParam(value = "query", defaultValue = "hello world") String query) {
        List<List<String>> res = this.parseService.queryTable(query);
        return ResponseEntity.ok().body(res);
    }
}