package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    //private MockMvc mockMvc;
    @Mock
    private UserRepository userRepositoryMock;
    @InjectMocks
    private UserServiceImpl userServiceImplMock;
    User userMock = User.builder()
            .userId("A1601")
            .userEmailId("userA1601@gmail.com")
            .userName("Demo User").build();

    @BeforeEach
    @Deprecated
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //this.mockMvc = MockMvcBuilders.standaloneSetup(userServiceMock).build();
    }

    @Test
    public void getAllUsersTest_SuccessResponse(){
        List<User> actualUserList = Collections.singletonList(userMock);
        when(userRepositoryMock.findAll()).thenReturn(actualUserList);

        List<User> expectedUserList = userServiceImplMock.getAllUser();
        Optional<User> expectedUser = expectedUserList.stream().findFirst();

        assertEquals(actualUserList.size(),expectedUserList.size());
        assertEquals(userMock.getUserId(),expectedUser.get().getUserId());
        assertEquals(userMock.getUserEmailId(),expectedUser.get().getUserEmailId());
        assertEquals(userMock.getUserName(),expectedUser.get().getUserName());

    }
}
