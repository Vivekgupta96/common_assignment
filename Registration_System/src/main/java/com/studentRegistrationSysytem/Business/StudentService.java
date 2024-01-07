package com.studentRegistrationSysytem.Business;

import com.studentRegistrationSysytem.Entity.Course;
import com.studentRegistrationSysytem.dto.ResponseDataDto;
import com.studentRegistrationSysytem.dto.StudentUpdateDto;

public interface StudentService {

    ResponseDataDto<Void> updateProfileDetails(Long studentId, StudentUpdateDto updateDto);

    ResponseDataDto<Course> searchAssignedTopics(Long studentId);

    ResponseDataDto<Void> leaveCourse(Long studentId, Course course);
}
