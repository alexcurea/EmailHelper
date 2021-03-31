package com.emailhelper.emailhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emailhelper.emailhelper.model.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}
