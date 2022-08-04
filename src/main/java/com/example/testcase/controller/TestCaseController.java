package com.example.testcase.controller;

import com.example.testcase.domain.*;
import com.example.testcase.repository.ChapterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/createTests")
public class TestCaseController {

    private final ChapterRepository repository;
    private TestCases testCases;

    public TestCaseController(ChapterRepository repository, TestCases testCases) {
        this.repository = repository;
        this.testCases = testCases;
    }

    @PostMapping
    public List<TestCase> testCaseList(@RequestBody List<TestCaseFromChapter> testCases) {
        List<TestCase> testCaseList = new ArrayList<>();
        List<Chapter> chapters = testCases.stream()
                .map(t -> repository.findById(t.getChapterId()).get())
                .collect(Collectors.toList());
        chapters.forEach(c -> testCaseList.addAll(c.getTestCaseList()));
        return testCaseList.stream()
                .filter(t -> testCases.stream()
                        .anyMatch(tc -> tc.getTestCaseId() == t.getId()))
                .distinct()
                .collect(Collectors.toList());
    }

}
