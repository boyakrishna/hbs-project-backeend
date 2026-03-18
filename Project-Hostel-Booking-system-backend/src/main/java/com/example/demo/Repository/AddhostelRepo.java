package com.example.demo.Repository;





import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Addhostel;


public interface AddhostelRepo extends JpaRepository<Addhostel, String>{
	
	Addhostel findByHostelidAndDob(String hostelid,LocalDate dob);

	

}
