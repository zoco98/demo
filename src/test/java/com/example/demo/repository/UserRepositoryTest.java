package com.example.demo.repository;

import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class UserRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private final UserRepository userRepositoryMock = mock(UserRepository.class);


    @Test
    public void findAllTest_SuccessResponse(){
        List<User> expectedUser= userRepositoryMock.findAll();

        assertThat(expectedUser).isEmpty();
    }
}
