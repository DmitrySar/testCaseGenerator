package com.example.testcase.repository;

import com.example.testcase.domain.Chapter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Integer> {
}
