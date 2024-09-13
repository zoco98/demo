package com.example.demo.entity;

import jakarta.validation.constraints.Pattern;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "userId")
    public String userId;
    @Column(name = "userName")
    public String userName;
    @Column(name = "userEmailId")
    public String userEmailId;
}
