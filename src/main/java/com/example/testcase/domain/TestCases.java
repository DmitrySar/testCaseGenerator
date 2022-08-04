package com.example.testcase.domain;

import org.springframework.stereotype.Component;

import java.util.List;

public class TestCases {

    private List<TestCase> testCases;

    public TestCases() {
    }

    public TestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }
}
