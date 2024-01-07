package com.studentRegistrationSysytem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseUploadDto {

    @NotNull(message = "courseName cannot be null")
    private String courseName;

    @NotNull(message = "description cannot be null")
    private String description;

    @NotNull(message = "courseType cannot be null")
    private String courseType;

    @NotNull(message = "duration cannot be null")
    private int duration;
}
