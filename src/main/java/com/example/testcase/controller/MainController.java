package com.example.testcase.controller;

import com.example.testcase.domain.Chapter;
import com.example.testcase.domain.Step;
import com.example.testcase.domain.TestCase;
import com.example.testcase.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

    @Autowired
    private ChapterRepository repository;

    @GetMapping("/chapter")
    public String addNewChapter(@RequestParam String chapterName) {
        Chapter chapter = new Chapter();
        chapter.setName(chapterName);
        repository.save(chapter);
        return "redirect:/";
    }

    @GetMapping("/testcase")
    public String addTestCase(@RequestParam(defaultValue = "0") int chapterId,
                              @RequestParam(defaultValue = "") String caseName,
                              @RequestParam(defaultValue = "") String expResult,
                              @RequestParam(defaultValue = "") String condition,
                              @RequestParam(defaultValue = "") String[] stepNames) {
        if (caseName.equals("")) return "redirect:/";
        TestCase testCase = new TestCase();
        testCase.setName(caseName);
        testCase.setExpResult(expResult);
        testCase.setCondition(condition);
        List<Step> stepList = IntStream.range(0, stepNames.length)
                .mapToObj(i -> new Step(stepNames[i], "")).collect(Collectors.toList());
        testCase.setStepList(stepList);
        Chapter chapter = repository.findById(chapterId).get();
        chapter.addTestCase(testCase);
        repository.save(chapter);
        return "redirect:/";
    }

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("chapters", repository.findAll());
        return "index";
    }
}
