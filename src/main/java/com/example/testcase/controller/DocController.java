package com.example.testcase.controller;

import com.example.testcase.service.Docx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocController {

    final
    Docx docx;

    public DocController(Docx docx) {
        this.docx = docx;
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET, produces="application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public @ResponseBody byte[] convertToDoc() {
        return docx.fromString("Hello!");
    }
}
