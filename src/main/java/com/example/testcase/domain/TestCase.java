package com.example.testcase.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class TestCase {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String expResult;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Step> stepList = new ArrayList<>();

    public TestCase(String name, List<Step> stepList) {
        this.name = name;
        this.stepList = stepList;
    }

    public void addStep(Step step) {
        stepList.add(step);
    }
}