package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Data
@Table(name = "User")
@AllArgsConstructor
@Getter
@Setter
public class User {
}
