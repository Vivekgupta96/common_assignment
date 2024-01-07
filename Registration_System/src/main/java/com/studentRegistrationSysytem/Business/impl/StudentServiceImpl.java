package com.studentRegistrationSysytem.Business.impl;

import com.studentRegistrationSysytem.Business.StudentService;
import com.studentRegistrationSysytem.Entity.Course;
import com.studentRegistrationSysytem.dto.ResponseDataDto;
import com.studentRegistrationSysytem.dto.StudentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Override
    public ResponseDataDto<Void> updateProfileDetails(Long studentId, StudentUpdateDto updateDto) {
        return null;
    }

    @Override
    public ResponseDataDto<Course> searchAssignedTopics(Long studentId) {
        return null;
    }

    @Override
    public ResponseDataDto<Void> leaveCourse(Long studentId, Course course) {
        return null;
    }
}
