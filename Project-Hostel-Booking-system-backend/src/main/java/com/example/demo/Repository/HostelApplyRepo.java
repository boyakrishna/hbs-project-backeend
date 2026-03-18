package com.example.demo.Repository;

import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HostelApplication;

public interface HostelApplyRepo extends JpaRepository<HostelApplication,String> {
	
    // Correct: returns the entity matching Application ID and DOB

	HostelApplication findByApplicationIdAndDob(String applicationId, LocalDate dob);
	 

}
