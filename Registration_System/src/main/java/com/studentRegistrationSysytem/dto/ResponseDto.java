package com.studentRegistrationSysytem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 7643234642529170223L;

    private String responseMessage;
    private String statusMsg;
    private  String statusCode;


}
