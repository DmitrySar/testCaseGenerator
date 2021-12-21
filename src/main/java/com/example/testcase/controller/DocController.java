package com.example.testcase.controller;

import com.example.testcase.domain.TestCase;
import com.example.testcase.service.Docx;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.swing.text.html.HTMLDocument;
import java.util.List;

@RestController
public class DocController {

    final
    Docx docx;

    public DocController(Docx docx) {
        this.docx = docx;
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST,
            produces="application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public @ResponseBody byte[] convertToDoc(@RequestParam String text) {
        text = text.replaceAll("<.>", "");
        return docx.fromString(text.split("<.{2}>"));
    }
}
