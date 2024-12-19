# Quizconceptile

A Spring Boot application to manage a quiz system via RESTful APIs. This app enables users to start a quiz session, retrieve random questions, submit answers, and track their performance.

## Features

1. Start a new quiz session.
2. Fetch a random multiple-choice question from the database.
3. Submit an answer to a question.
4. Retrieve the total questions answered by the user, including details on correct and incorrect submissions.

## Installation

### Prerequisites

- Java 17 or higher
- Maven
- A database (e.g., MySQL, PostgreSQL)

### Steps
  }
  ```

### 3. Submit Answer
- **Endpoint**: `POST /api/quiz/answer`
- **Description**: Submits an answer to a question.
- **Request Body**:
  ```json
  {
    "sessionId": "abc123",
    "questionId": "q1",
    "answer": "Paris"
  }
  ```
- **Response**:
  ```json
  {
    "correct": true,
    "message": "Correct answer!"
  }
  ```

### 4. Get Quiz Summary
- **Endpoint**: `GET /api/quiz/summary/{sessionId}`
- **Description**: Retrieves the total questions answered by the user along with details on correct and incorrect submissions.
- **Response**:
  ```json
  {
    "totalQuestions": 10,
    "correctAnswers": 7,
    "incorrectAnswers": 3,
    "details": [
      {
        "question": "What is the capital of France?",
        "submittedAnswer": "Paris",
        "correct": true
      },
      {
        "question": "What is 2 + 2?",
        "submittedAnswer": "5",
        "correct": false
      }
    ]
  }
  ```

## Technologies Used

- **Backend**: Spring Boot
- **Database**: MySQL/PostgreSQL
- **Build Tool**: Maven

## Future Enhancements

- Add user authentication and authorization.
- Implement a leaderboard system.
- Add support for timed quizzes.

