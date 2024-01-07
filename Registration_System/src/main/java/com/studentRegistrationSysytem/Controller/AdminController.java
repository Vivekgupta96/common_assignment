package com.studentRegistrationSysytem.Controller;

import com.studentRegistrationSysytem.Business.AdminService;
import com.studentRegistrationSysytem.dto.*;
import com.studentRegistrationSysytem.utils.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {


    private  final AdminService adminService;

    @PostMapping("/student/register")
    public ResponseEntity<ResponseDataDto<?>> registerStudent(
            @Valid  @RequestBody StudentAdmitDto studentDTO) {

        ResponseDataDto<?> response = adminService.admitStudentByAdmin(studentDTO);
        return switch (response.getStatusCode().toLowerCase()) {
            case "201" -> ResponseUtils.getCreatedResponse(response);
            case "404" -> ResponseUtils.getNotFoundResponse(response);
            default -> ResponseUtils.getInternalServerErrorResponse(response);
        };

    }


    @PostMapping("/course/upload")
    public ResponseEntity<ResponseDataDto<?>> uploadCourse(@Valid @RequestBody CourseUploadDto uploadDto) {
        ResponseDataDto<?> response = adminService.courseUpload(uploadDto);
        return switch (response.getStatusCode().toLowerCase()) {
            case "201" -> ResponseUtils.getCreatedResponse(response);
            case "404" -> ResponseUtils.getNotFoundResponse(response);
            default -> ResponseUtils.getInternalServerErrorResponse(response);
        };
    }


    @PutMapping("/course/assign")
    public ResponseEntity<ResponseDto> courseAssignToStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        ResponseDto response=adminService.courseAssignToStudent(studentId,courseId);
        return switch (response.getStatusCode().toLowerCase()) {
            case "200" -> ResponseUtils.getCreatedResponse(response);
            case "404" -> ResponseUtils.getNotFoundResponse(response);
            default -> ResponseUtils.getInternalServerErrorResponse(response);
        };
    }


    @GetMapping("/student/byName")
    public ResponseEntity<ResponseListDto<?>> getStudentsByName(@RequestParam String studentName) {
        ResponseListDto<?> response = adminService.getStudentsByName(studentName);
        return switch (response.getStatusCode().toLowerCase()) {
            case "200" -> ResponseUtils.getCreatedResponse(response);
            case "404" -> ResponseUtils.getNotFoundResponse(response);
            default -> ResponseUtils.getInternalServerErrorResponse(response);
        };
    }

    @GetMapping("/student-byCourse-name")
    public ResponseEntity<ResponseListDto<?>> getStudentsByCourse(@RequestParam String courseName) {
        ResponseListDto<?> response = adminService.getStudentsByCourse(courseName);
        return switch (response.getStatusCode().toLowerCase()) {
            case "200" -> ResponseUtils.getCreatedResponse(response);
            case "404" -> ResponseUtils.getNotFoundResponse(response);
            default -> ResponseUtils.getInternalServerErrorResponse(response);
        };
    }
}

