package com.studentRegistrationSysytem.Repo;

import com.studentRegistrationSysytem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findByName(String name);
}
