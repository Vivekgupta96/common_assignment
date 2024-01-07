package com.studentRegistrationSysytem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Student_Table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "unique_student_code", unique = true)
	private String uniqueStudentCode;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<StudentAddress> addresses=new ArrayList<>();


	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "students")
	private Set<Course> courses=new HashSet<>();


}
