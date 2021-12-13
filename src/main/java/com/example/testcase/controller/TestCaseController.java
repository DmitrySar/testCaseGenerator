package com.example.testcase.controller;

import com.example.testcase.domain.Chapter;
import com.example.testcase.repository.ChapterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/createTests")
public class TestCaseController {

    private final ChapterRepository repository;

    public TestCaseController(ChapterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Chapter> testCaseList(@RequestParam String[] testCases) {

        List<Chapter> chapters = new ArrayList<>();
        repository.findAll().forEach(chapters::add);
        //TODO create filter
        return chapters;
    }
}
