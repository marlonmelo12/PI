package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;
    @GetMapping()
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("SUCESS");
    }
    @GetMapping("/list")
    public ResponseEntity<List<User>> listUsers(){
        List <User> users = userService.listUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);

    }
    @GetMapping("/rank")
    public ResponseEntity<List<User>> rankUsers(){
        List<User> rank = userService.rankUsers();
        if(rank.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rank);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertUser(@RequestBody UserDTO user){
        try{
            User newUser = userService.insertUser(user);
            return ResponseEntity.ok(newUser);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body("Erro ao inserir usuario");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        try{
            User user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/edit/{userId}")
    public ResponseEntity<?> editUser(@PathVariable String userId, @RequestBody UserDTO user){
        try{
            User editUser = userService.editUser(userId, user);
            return ResponseEntity.ok(editUser);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Erro ao editar usuario");
        }
    }
    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable String userId){   
        try{
            userService.deleteUser(userId);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Erro ao excluir usuario");
        }
    }
}
