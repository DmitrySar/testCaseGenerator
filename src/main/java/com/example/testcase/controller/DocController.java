package com.example.testcase.controller;

import com.example.testcase.service.Docx;
import org.springframework.web.bind.annotation.*;

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
        return docx.fromString(text);
    }
}
