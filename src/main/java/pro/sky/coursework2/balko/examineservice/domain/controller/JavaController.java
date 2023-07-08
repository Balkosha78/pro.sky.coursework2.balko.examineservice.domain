package pro.sky.coursework2.balko.examineservice.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.balko.examineservice.domain.model.Question;
import pro.sky.coursework2.balko.examineservice.domain.service.QuestionService;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam ("question") String question, @RequestParam("answer") String answer){
        return questionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam ("question") String question, @RequestParam("answer") String answer){
        return questionService.remove(question,answer);
    }
    public Collection<Question> getAll(){
        return questionService.getAll();
    }

}
