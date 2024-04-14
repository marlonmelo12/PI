package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Question;
import com.example.demo.repositories.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> listQuestions(){
        return questionRepository.findAll();
    }
    public Question insertQuestion(QuestionDTO body) {
        try {
            Question newQuestion = new Question();
            newQuestion.setQuestion(body.question());
            newQuestion.setOption1(body.option1());
            newQuestion.setOption2(body.option2());
            newQuestion.setOption3(body.option3());
            newQuestion.setAnswer(body.answer());
            return questionRepository.save(newQuestion);
        } catch (DataIntegrityViolationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir a pergunta");
        }
    }
    public void deleteQuestion(Long questionId){
        if(questionRepository.existsById(questionId)){
            questionRepository.deleteById(questionId);
        }else{
            throw new IllegalArgumentException("id não encontrado");
        }
    }
    public Question editQuestion(Long questionId, QuestionDTO body){
        Question editQuestion = new Question();
        editQuestion = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("User not found"));
        try{
            editQuestion.setQuestion(body.question());
            editQuestion.setOption1(body.option1());
            editQuestion.setOption2(body.option2());
            editQuestion.setOption3(body.option3());
            editQuestion.setAnswer(body.answer());
            return questionRepository.save(editQuestion);
        }catch (DataIntegrityViolationException e) {
            throw e;
        }
    }
}
