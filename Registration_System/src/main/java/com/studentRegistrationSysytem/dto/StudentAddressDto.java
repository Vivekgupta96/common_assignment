package com.studentRegistrationSysytem.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddressDto {

    @NotNull(message = "Area cannot be null")
    private String area;

    @NotNull(message = "State cannot be null")
    private String state;

    @NotNull(message = "District cannot be null")
    private String district;

    @NotNull(message = "Pincode cannot be null")
    private String pincode;

    @NotNull(message = "Address type cannot be null")
    private String addressType;


}
