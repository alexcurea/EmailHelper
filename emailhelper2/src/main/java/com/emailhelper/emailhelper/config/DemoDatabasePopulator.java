package com.emailhelper.emailhelper.config;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.emailhelper.emailhelper.model.*;
import com.emailhelper.emailhelper.model.enums.CandidateStatus;
import com.emailhelper.emailhelper.model.enums.ERole;
import com.emailhelper.emailhelper.repository.CandidateRepository;
import com.emailhelper.emailhelper.repository.EnrollmentRepository;
import com.emailhelper.emailhelper.repository.RoleRepository;

@ComponentScan(basePackages = "com.helpdesk") 
@Component
public class DemoDatabasePopulator {
	
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	@Autowired 
	private RoleRepository roleRepository;
	@Primary
	@PostConstruct
	public void populateDatabase() {
		if (this.candidateRepository.count() == 0){
		for (int i = 0; i < 3; i++) {
			if(i==0) {
				Role roleUser = new Role(ERole.ROLE_USER);
				this.roleRepository.save(roleUser);
			}
			if(i==1) {
				Role roleModerator = new Role(ERole.ROLE_MODERATOR);
				this.roleRepository.save(roleModerator);
			}
			if(i==2) {
				Role roleAdmin = new Role(ERole.ROLE_ADMIN);
				this.roleRepository.save(roleAdmin);
			}
			
		}
		}




		if (this.candidateRepository.count() == 0 &&
				this.enrollmentRepository.count() == 0) {
			Candidate candidate = new Candidate();
			candidate.setFirstName("Cristian");
			candidate.setLastName("Dumitrache");
			candidate.setCandidateStatus(CandidateStatus.REJECTED);
			candidate.setBirthDate(new Date());
			candidate.setCity("Buzau");
			candidate.setCountry("Romania");
			candidate.setEmail("cdr@yahoo.com");
			candidate.setPhoneNumber("0792929292");
			this.candidateRepository.save(candidate);
			Candidate candidate2 = new Candidate();
			candidate2.setFirstName("Curea");
			candidate2.setLastName("Alexandru");
			candidate2.setCandidateStatus(CandidateStatus.ACCEPTED);
			candidate2.setBirthDate(new Date());
			candidate2.setCity("Rm. Sarat");
			candidate2.setCountry("Romania");
			candidate2.setEmail("alex20_96@yahoo.com");
			candidate2.setPhoneNumber("0744464464");
			this.candidateRepository.save(candidate2);
			Candidate candidate3 = new Candidate();
			candidate3.setFirstName("Mihaela");
			candidate3.setLastName("Vitan");
			candidate3.setCandidateStatus(CandidateStatus.ACCEPTED);
			candidate3.setBirthDate(new Date());
			candidate3.setCity("Bucuresti");
			candidate3.setCountry("Romania");
			candidate3.setEmail("mihav@gmail.com");
			candidate3.setPhoneNumber("0791112222");
			this.candidateRepository.save(candidate3);
		}
	}
	
}
