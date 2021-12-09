package com.example.testcase.controller;

import com.example.testcase.domain.Chapter;
import com.example.testcase.domain.TestCase;
import com.example.testcase.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    protected ChapterRepository repository;

    @GetMapping("delChapter")
    public String delChapter(@RequestParam int id) {
        repository.delete(repository.findById(id).get());
        return "redirect:/";
    }

    @GetMapping("delTest")
    public String delTest(@RequestParam int chapterId,
                          @RequestParam int testId) {
        Chapter chapter = repository.findById(chapterId).get();
        TestCase testCase = chapter.getTestCaseList().stream()
                .filter(t -> t.getId() == testId)
                .findFirst()
                .get();
        chapter.getTestCaseList().remove(testCase);
        repository.save(chapter);
        return "redirect:/";
    }
}
