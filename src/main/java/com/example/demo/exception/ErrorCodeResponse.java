package com.example.demo.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorCodeResponse {

    private int statusCode;
    private String errorCode;
    private String errorMsg;
}
