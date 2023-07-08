package pro.sky.coursework2.balko.examineservice.domain.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.balko.examineservice.domain.exception.NotEnoughQuestionsInStorage;
import pro.sky.coursework2.balko.examineservice.domain.model.Question;
import pro.sky.coursework2.balko.examineservice.domain.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.fasterxml.jackson.databind.util.LinkedNode.contains;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    public void shouldThrowExceptionWhenAmountMoreThenAvailableQuestions(){
        // given
        int amount = 6;
        when(questionService.getAll().thenReturn(Collections.emptyList()));
        // when
        // then
        Assertions.assertThrows(NotEnoughQuestionsInStorage.class,
                () -> examinerService.getQuestions(amount));
    }
    @Test
    public void shouldSuccessfullyGenerateRandomQuestions(){
        // given
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        questions.add(new Question("Question 3", "Answer 3"));
        questions.add(new Question("Question 4", "Answer 4"));
        questions.add(new Question("Question 5", "Answer 5"));

        int amount = 4;

        when(questionService.getAll().thenReturn(questions));
        when(questionService.getRandomQuestion().thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(1),
                questions.get(2)
        ));
        // when
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        // then
        Assertions.assertEquals(amount, actualQuestions.size());
        Assertions.assertTrue(actualQuestions,contains(questions.get(0)));
        Assertions.assertTrue(actualQuestions,contains(questions.get(1)));
        Assertions.assertTrue(actualQuestions,contains(questions.get(2)));

        verify(questionService, times(4)).getRandomQuestion();
    }
}
