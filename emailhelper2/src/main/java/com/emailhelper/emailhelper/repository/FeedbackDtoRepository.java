package com.emailhelper.emailhelper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emailhelper.emailhelper.model.FeedbackDto;

public interface FeedbackDtoRepository extends JpaRepository<FeedbackDto, Long> {
	
	List<FeedbackDto> findByAdress(String adress);

}
