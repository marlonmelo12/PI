package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "TB_user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
    private String userId;
    @Column(name = "name_user")
    private String name;
    @Column(name = "name_login")
    private String login;
    @Column(name = "name_password")
    private String password;
    @Column(name = "user_amount")
    private Integer amount;
    @Column(name = "user_avatar")
    private String avatar;
}
