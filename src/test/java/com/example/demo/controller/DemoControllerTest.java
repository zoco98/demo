package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.serviceImpl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {
    private MockMvc mockMvc;
    /*converts json object to string*/
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private UserServiceImpl userServiceImplMock = mock(UserServiceImpl.class);
    @InjectMocks
    private DemoController demoControllerMock;
    User userMock = User.builder()
            .userId("A1601")
            .userEmailId("userA1601@gmail.com")
            .userName("Demo User").build();
    @BeforeEach
    @Deprecated
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(demoControllerMock).build();
    }

    @Test
    public void loadDataTest_SuccessResponse() throws Exception {
        List<User> userList = Collections.singletonList(userMock);
        when(userServiceImplMock.getAllUser()).thenReturn(userList);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/getLoading")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId",is("A1601")));
    }

}
