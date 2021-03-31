package com.emailhelper.emailhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emailhelper.emailhelper.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
