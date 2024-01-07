package com.studentRegistrationSysytem.Business;

import com.studentRegistrationSysytem.Entity.Course;
import com.studentRegistrationSysytem.Entity.Student;
import com.studentRegistrationSysytem.dto.*;

public interface AdminService {

    ResponseDataDto<Student> admitStudentByAdmin(StudentAdmitDto adminReq);

    ResponseDataDto<Course> courseUpload(CourseUploadDto uploadReq);

    ResponseDto courseAssignToStudent(Long studentId, Long courseId);

    ResponseListDto<Student> getStudentsByName(String studentName);

    ResponseListDto<Student> getStudentsByCourse(String course);



}
