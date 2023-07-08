package pro.sky.coursework2.balko.examineservice.domain.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.balko.examineservice.domain.exception.NotEnoughQuestionsInStorage;
import pro.sky.coursework2.balko.examineservice.domain.model.Question;
import pro.sky.coursework2.balko.examineservice.domain.service.ExaminerService;
import pro.sky.coursework2.balko.examineservice.domain.service.QuestionService;

import java.util.*;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()){
            throw new NotEnoughQuestionsInStorage();
        }
        Set<Question>randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount){
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
