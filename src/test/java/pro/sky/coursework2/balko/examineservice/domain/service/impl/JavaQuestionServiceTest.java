package pro.sky.coursework2.balko.examineservice.domain.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.balko.examineservice.domain.model.Question;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    @Test
    public void shouldRemoveExistedQuestion(){
        // given
        Question question = new Question("question", "answer");
        javaQuestionService.add(question);

        // when
        Question removedQuestion = javaQuestionService.remove(question);

        // then
        Assertions.assertEquals(question, removedQuestion);
    }
    @Test
    public void shouldRemoveNonExistedQuestionAndReturnNull(){
        // given
        Question question = new Question("question", "answer");

        // when
        Question removedQuestion = javaQuestionService.remove(question);

        // then
        Assertions.assertNull(removedQuestion);
    }
}
