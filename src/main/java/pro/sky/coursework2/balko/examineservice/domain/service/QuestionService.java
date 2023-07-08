package pro.sky.coursework2.balko.examineservice.domain.service;

import pro.sky.coursework2.balko.examineservice.domain.model.Question;

import java.util.Collection;


public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();
    Question getRandomQuestion();

}
