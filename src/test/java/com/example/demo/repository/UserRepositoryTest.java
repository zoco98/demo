package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.support.DefaultTestContextBootstrapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
@EnableAutoConfiguration
@EntityScan(basePackages = "com.example.demo.entity")
@ActiveProfiles("test")
@BootstrapWith(DefaultTestContextBootstrapper.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private final UserRepository userRepositoryMock = mock(UserRepository.class);
    User userMock = User.builder()
            .userId("A1601")
            .userEmailId("userA1601@gmail.com")
            .userName("Demo User").build();
    @BeforeEach
    void setUp() {
        userRepositoryMock.save(userMock);
    }

    @AfterEach
    void tearDown(){
        userRepositoryMock.deleteAll();
    }
    @Test
    public void findAllTest_SuccessResponse(){
        List<User> expectedUser= userRepositoryMock.findAll();

        assertThat(expectedUser).isNotEmpty();
        assertThat(expectedUser.get(0).getUserEmailId()).isEqualTo(userMock.getUserEmailId());
    }
}
