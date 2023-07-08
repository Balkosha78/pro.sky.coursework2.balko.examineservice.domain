package pro.sky.coursework2.balko.examineservice.domain.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.balko.examineservice.domain.model.Question;
import pro.sky.coursework2.balko.examineservice.domain.service.QuestionService;

import javax.annotation.PostConstruct;
import java.util.*;

@Service

    public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();
    @PostConstruct
    public void setup(){
        questions.add(new Question("Question 1", "Answer 1"));
        questions.add(new Question("Question 2", "Answer 2"));
        questions.add(new Question("Question 3", "Answer 3"));
        questions.add(new Question("Question 4", "Answer 4"));
        questions.add(new Question("Question 5", "Answer 5"));
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }
    @Override
    public Question remove(String question, String answer){
        return remove(new Question(question, answer));
    }
    @Override
    public Question remove(Question question) {
        boolean isRemoved = questions.remove(question);
        return isRemoved ? question : null;
    }
    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }

}
