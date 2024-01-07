package com.studentRegistrationSysytem.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataDto<T> extends ResponseDto {

   private T data;
}
