package com.valtech.training.result.controllers;

import com.valtech.training.result.services.ResultService;
import com.valtech.training.result.vos.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/v1/results")
public class ResultController {
 
    @Autowired
    private ResultService resultService;
 
    @PostMapping("/save")
    public ResultVO saveResult(@RequestParam Long quizId, @RequestParam String name, @RequestParam int score) {
        return resultService.saveResult(quizId, name, score);
    }
 
    @GetMapping("/user/{userName}")
    public List<ResultVO> getResultsByUser(@PathVariable String userName) {
        return resultService.getResultsByUser(userName);
    }
 
    @GetMapping("/quiz/{quizId}")
    public List<ResultVO> getResultsByQuiz(@PathVariable Long quizId) {
        return resultService.getResultsByQuiz(quizId);
    }
}
 
 