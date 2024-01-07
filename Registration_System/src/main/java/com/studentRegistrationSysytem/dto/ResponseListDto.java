package com.studentRegistrationSysytem.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListDto<T>  extends  ResponseDto{

    List<T> dataList;


}
