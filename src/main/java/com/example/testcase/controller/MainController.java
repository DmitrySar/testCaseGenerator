package com.example.testcase.controller;

import com.example.testcase.domain.Chapter;
import com.example.testcase.domain.TestCase;
import com.example.testcase.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private ChapterRepository repository;

    @GetMapping("/chapter")
    public String addNewChapter(@RequestParam String chapterName) {
        Chapter chapter = new Chapter();
        chapter.setName(chapterName);
        repository.save(chapter);
        return "redirect:/index";
    }

    @GetMapping("/testcase")
    public String addTestCase(@RequestParam int chapterId,
                              @RequestParam String caseName) {
        TestCase testCase = new TestCase();
        testCase.setName(caseName);
        Chapter chapter = repository.findById(chapterId).get();
        chapter.addTestCase(testCase);
        repository.save(chapter);
        return "redirect:/index";
    }

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("chapters", repository.findAll());
        return "index";
    }
}
