package com.studentRegistrationSysytem.Business.impl;

import com.studentRegistrationSysytem.Business.AdminService;
import com.studentRegistrationSysytem.Entity.Course;
import com.studentRegistrationSysytem.Entity.Student;
import com.studentRegistrationSysytem.Repo.CourseRepo;
import com.studentRegistrationSysytem.Repo.StudentRepo;
import com.studentRegistrationSysytem.dto.*;
import com.studentRegistrationSysytem.exceptions.ResourcesNotFoundException;
import com.studentRegistrationSysytem.mapper.MapperClass;
import com.studentRegistrationSysytem.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final StudentRepo studentRepo;

    private final CourseRepo courseRepo;

    @Override
    public ResponseDataDto<Student> admitStudentByAdmin(StudentAdmitDto admitReq) {

        if (admitReq == null) {
            throw new RuntimeException("Please Provide the Required Details , It can not be Null");
        }
        try {
            return ResponseUtils.saveDataResponse("Student Admitted successfully ",
                    studentRepo.save(MapperClass.mapToStudent(admitReq)));
        } catch (DataAccessException e) {
            return ResponseUtils.createNotFoundResponseForData(
                    "Internal Server Error..Try after sometimes"+ e);
        }
    }


    @Override
    public ResponseDataDto<Course> courseUpload(CourseUploadDto uploadReq) {
        if (uploadReq == null) {
            throw new RuntimeException("Please Provide the Required Details , It can not be Null");
        }
        try {
            return ResponseUtils.saveDataResponse("Course Uploaded By admin successfully ",
                    courseRepo.save(MapperClass.mapToCourse(uploadReq)));
        } catch (DataAccessException e) {
            return ResponseUtils.createNotFoundResponseForData(
                    "Internal Server Error..Try after sometimes"+ e);
        }
    }

    @Override
    public ResponseDto courseAssignToStudent(Long studentId, Long courseId) {

        if(!StringUtils.isNotEmpty(String.valueOf(studentId))||!StringUtils.isNotEmpty(String.valueOf(courseId))){
            throw new ResourcesNotFoundException("Please Provide the Valid username OR CompanyName");
        }
        Optional<Student> existingStudent = studentRepo.findById(studentId);
          if(existingStudent.isEmpty()){
              throw new ResourcesNotFoundException("No data found");
          }
        Optional<Course> existingCourse = courseRepo.findById(courseId);
        if(existingCourse.isEmpty()){
            throw new ResourcesNotFoundException("No data found");
        }
        ResponseDto response=new ResponseDto();
        Student std=existingStudent.get();
        std.getCourses().add(existingCourse.get());
        studentRepo.save(std);

        response.setResponseMessage("Course Assige to Student Successfully");
        response.setStatusCode("200");
        response.setStatusMsg("ok");
        return response;

    }


    @Override
    public ResponseListDto<Student> getStudentsByName(String studentName) {

        if(!StringUtils.isNotEmpty(studentName)){
            throw new ResourcesNotFoundException("Please Provide the Valid name ");
        }
        try{
            List<Student>  studentList=studentRepo.findByName(studentName);
            if(studentList.isEmpty()){
                return ResponseUtils.createNotFoundResponse("Student not found with provided Name");
            }else{
                return ResponseUtils.createOKResponse("Student data fetch successfully",studentList);
            }
        }catch(DataAccessException e){
            return ResponseUtils.createInternalServerErrorResponse(e);
        }

    }

    @Override
    public ResponseListDto<Student> getStudentsByCourse(String courseName) {
        if(!StringUtils.isNotEmpty(courseName)){
            throw new ResourcesNotFoundException("Please Provide the Valid course name ");
        }
        try{
            List<Course>  course=courseRepo.findByCourseName(courseName);
            Set<Student>  students=course.get(0).getStudents();
            if(students.isEmpty()){
                return ResponseUtils.createNotFoundResponse("course not found with provided Name");
            }else{
                return ResponseUtils.createOKResponse("Student data fetch successfully",new ArrayList<>(students));
            }
        }catch(DataAccessException e){
            return ResponseUtils.createInternalServerErrorResponse(e);
        }

    }
}
