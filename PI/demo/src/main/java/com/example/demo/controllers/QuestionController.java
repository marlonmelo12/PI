package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.QuestionService;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/list")
    public ResponseEntity<List<Question>> listQuestions() {
        List<Question> questions = questionService.listQuestions();
        if (questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(questions);
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insertQuestion(@RequestBody QuestionDTO question){
        try{
            Question newQuestion = questionService.insertQuestion(question);
            return ResponseEntity.ok(newQuestion);
        }catch(DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("Erro ao inserir usuario");
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Erro ao inserir usuario");
        }
    }
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        try {
            questionService.deleteQuestion(questionId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao excluir a pergunta");
        }
    }
   @PutMapping("insert/{questionId}")
    public ResponseEntity<?> editQuestion(@PathVariable Long questionId, @RequestBody QuestionDTO question) {
        try{
            Question updatedQuestion = questionService.editQuestion(questionId, question);
            return ResponseEntity.ok(updatedQuestion);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Erro ao editar pergunta");
        }
    }
}
