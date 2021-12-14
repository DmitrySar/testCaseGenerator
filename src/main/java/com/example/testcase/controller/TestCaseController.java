package com.example.testcase.controller;

import com.example.testcase.domain.Chapter;
import com.example.testcase.domain.Step;
import com.example.testcase.domain.TestCase;
import com.example.testcase.domain.TestCaseFromChapter;
import com.example.testcase.repository.ChapterRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/createTests")
public class TestCaseController {

    private final ChapterRepository repository;

    public TestCaseController(ChapterRepository repository) {
        this.repository = repository;
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
                .collect(Collectors.toList());

    }

}
