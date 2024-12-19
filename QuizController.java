package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz(@RequestParam Long userId) {
        return quizService.startQuiz(userId);
    }

    @GetMapping("/question")
    public Question getRandomQuestion() {
        return quizService.getRandomQuestion();
    }

    @PostMapping("/answer")
    public boolean submitAnswer(@RequestParam Long sessionId, @RequestParam Long questionId, @RequestParam String answer) {
        return quizService.submitAnswer(sessionId, questionId, answer);
    }

    @GetMapping("/summary/{sessionId}")
    public QuizSession getSummary(@PathVariable Long sessionId) {
        return quizService.getSummary(sessionId);
    }
}
