package pro.sky.coursework2.balko.examineservice.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.balko.examineservice.domain.model.Question;
import pro.sky.coursework2.balko.examineservice.domain.service.ExaminerService;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;
    public ExamController(ExaminerService examinerService){
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }

}
