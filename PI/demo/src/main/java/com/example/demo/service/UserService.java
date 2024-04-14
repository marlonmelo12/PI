package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
     public List<User> listUsers(){
        return userRepository.findAll();
    }
    public List<User> rankUsers(){
        return userRepository.rank();
    }
    public User insertUser(UserDTO body){
        try{
            User newUser = new User();
            newUser.setName(body.name());
            newUser.setLogin(body.login());
            newUser.setPassword(body.password());
            newUser.setAvatar(body.avatar());
            newUser.setAmount(0);
            return userRepository.save(newUser);
        }catch(Exception e){
            throw new RuntimeException("Erro ao inserir usuário");
        }  
    }
    public User getUserById(String userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("id não identificado"));
        return user;
    }
    public void deleteUser(String userId){
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
        }else{
            throw new IllegalArgumentException("Id não encontrado");
        }
    }
    public User editUser(String userId, UserDTO user){
        try{
            User editUser = new User();
            editUser.setName(user.name());
            editUser.setLogin(user.login());
            editUser.setPassword(user.password());
            editUser.setAvatar(user.avatar());
            return userRepository.save(editUser);
        }catch(Exception e){
            throw new RuntimeException("Erro ao editar");
        }

    }
}
