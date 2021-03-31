package com.emailhelper.emailhelper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emailhelper.emailhelper.model.Enrollment;
import com.emailhelper.emailhelper.repository.EnrollmentRepository;

@RestController
public class EnrollmentController {
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@GetMapping(value= "/enrollment", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Enrollment> getEnrollments(){
		return this.enrollmentRepository.findAll();
	}
	
	@GetMapping(value = "/enrollment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollment getEnrollment(@PathVariable("id") Long id) {
		Optional<Enrollment> enrollmentOpt = this.enrollmentRepository.findById(id);
		return enrollmentOpt.orElse(null);
	}
	
	@PostMapping(value = "/enrollment/create", consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
		return this.enrollmentRepository.save(enrollment);
	}
	
	@PutMapping(value = "/enrollment/update", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Enrollment updateEnrollment(@RequestBody Enrollment enrollment) {
		return this.enrollmentRepository.save(enrollment);
	}
	
	@DeleteMapping(value = "/enrollment/delete")
	public void deleteEnrollment(@RequestParam ("id") Long id) {
		if(enrollmentRepository.existsById(id)) {
			this.enrollmentRepository.deleteById(id);
		}
	}
}
