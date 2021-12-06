package com.example.testcase.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Chapter {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TestCase> testCaseList = new ArrayList<>();

    public Chapter(String name, List<TestCase> testCaseList) {
        this.name = name;
        this.testCaseList = testCaseList;
    }

    public void addTestCase(TestCase testCase) {
        testCaseList.add(testCase);
    }
}
