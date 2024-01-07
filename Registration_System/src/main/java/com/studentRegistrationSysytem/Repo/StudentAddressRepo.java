package com.studentRegistrationSysytem.Repo;

import com.studentRegistrationSysytem.Entity.StudentAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAddressRepo extends JpaRepository<StudentAddress,Long> {
}
