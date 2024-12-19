package com.example.quizapp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int totalQuestions;
    private int correctAnswers;

    @ElementCollection
    private List<String> attemptedQuestions = new ArrayList<>();

    // Getters and Setters
}
