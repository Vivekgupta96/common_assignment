package com.studentRegistrationSysytem.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentAdmitDto {


    private String name;
    private String dateOfBirth;
    private String gender;
    private String uniqueStudentCode;
    private List<StudentAddressDto> addresses;

}
