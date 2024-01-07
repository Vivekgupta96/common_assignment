package com.studentRegistrationSysytem.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class MyErrorClass1 {

    private List<String> message;
    private LocalDateTime localDateTimes;
    private String descption;
}
