package com.example.testcase.service;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Stream;

@Service
public class Docx {
    public byte[] fromString(String[] text) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XWPFDocument document = new XWPFDocument();
            for (String s: text) {
                document.createParagraph().createRun().setText(s);
            }
            document.write(out);
            return IOUtils.toByteArray(new ByteArrayInputStream(out.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
