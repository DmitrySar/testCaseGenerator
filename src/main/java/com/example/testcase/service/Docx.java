package com.example.testcase.service;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class Docx {
    public byte[] fromString(String text) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XWPFDocument document = new XWPFDocument();
            for (String s: text.split("</p>")) {
                s = s.substring(3);
                for (String b: s.split("</b>")) {
                    boolean isBold = b.startsWith("<b>") ? true : false;
                    if (b.startsWith("<br>")) b = b.substring(4) + "\n";
                    if (isBold) b = b.substring(3);
                    XWPFRun run = document.createParagraph().createRun();
                    run.setBold(isBold);
                    run.setText(b);
                }
            }
            document.write(out);
            return IOUtils.toByteArray(new ByteArrayInputStream(out.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
