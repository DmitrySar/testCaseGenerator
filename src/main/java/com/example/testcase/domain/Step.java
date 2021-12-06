package com.example.testcase.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Step {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String expResult;

    public Step(String name, String expResult) {
        this.name = name;
        this.expResult = expResult;
    }
}
