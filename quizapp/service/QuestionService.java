package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //you can also use component
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public List<Question> getQuestionsByCategory(String category){
        return questionDAO.findByCategory(category);
    }
    public ResponseEntity<String> addQuestion(Question question){
       questionDAO.save(question);
       return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
}
