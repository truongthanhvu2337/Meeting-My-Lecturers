package com.fpt.MeetLecturer.repository;

import com.fpt.MeetLecturer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}