package pro.sky.coursework2.balko.examineservice.domain.service;

import pro.sky.coursework2.balko.examineservice.domain.model.Question;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
