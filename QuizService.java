package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizSession;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startQuiz(Long userId) {
        QuizSession session = new QuizSession();
        session.setUserId(userId);
        return quizSessionRepository.save(session);
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        long count = questionRepository.count();
        return questionRepository.findById((long) (random.nextInt((int) count) + 1)).orElse(null);
    }

    public boolean submitAnswer(Long sessionId, Long questionId, String answer) {
        Optional<QuizSession> session = quizSessionRepository.findById(sessionId);
        Optional<Question> question = questionRepository.findById(questionId);

        if (session.isPresent() && question.isPresent()) {
            QuizSession quizSession = session.get();
            quizSession.setTotalQuestions(quizSession.getTotalQuestions() + 1);

            if (question.get().getCorrectAnswer().equals(answer)) {
                quizSession.setCorrectAnswers(quizSession.getCorrectAnswers() + 1);
            }

            quizSession.getAttemptedQuestions().add(question.get().getQuestionText());
            quizSessionRepository.save(quizSession);
            return question.get().getCorrectAnswer().equals(answer);
        }

        return false;
    }

    public QuizSession getSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElse(null);
    }
}
