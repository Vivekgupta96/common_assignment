package com.studentRegistrationSysytem.Repo;

import com.studentRegistrationSysytem.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Long> {

    List<Course> findByCourseName(String courseName);
}
