package com.studentRegistrationSysytem.mapper;


import com.studentRegistrationSysytem.Entity.Course;
import com.studentRegistrationSysytem.Entity.Student;
import com.studentRegistrationSysytem.Entity.StudentAddress;
import com.studentRegistrationSysytem.dto.CourseUploadDto;
import com.studentRegistrationSysytem.dto.StudentAddressDto;
import com.studentRegistrationSysytem.dto.StudentAdmitDto;
import com.studentRegistrationSysytem.utils.AutoGenerateUniqIDs;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class MapperClass {

    public static Student mapToStudent(StudentAdmitDto req){
        Student newStd=new Student();
        newStd.setName(req.getName());
        newStd.setGender(req.getGender());
        newStd.setDateOfBirth(req.getDateOfBirth());
        newStd.setUniqueStudentCode(AutoGenerateUniqIDs.uniqueId(req.getName()));
        newStd.setAddresses(MapperClass.mapToStudentAddressList(req.getAddresses()));
        return newStd;
    }
     public static List<StudentAddress> mapToStudentAddressList(List<StudentAddressDto> address){
         List<StudentAddress> newAddress=new ArrayList<>();
         for(StudentAddressDto add:address){

             StudentAddress sAdd=new StudentAddress();
             BeanUtils.copyProperties(add,sAdd);
             newAddress.add(sAdd);
         }
         return newAddress;
     }

    public static Course mapToCourse(CourseUploadDto uploadReq) {
        Course newCourse=new Course();
        BeanUtils.copyProperties(uploadReq,newCourse);
        return newCourse;
    }
}

