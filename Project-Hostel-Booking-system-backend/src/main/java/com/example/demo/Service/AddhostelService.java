package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AddhostelRepo;
import com.example.demo.entity.Addhostel;

@Service
public class AddhostelService {
	
	@Autowired
	private AddhostelRepo repo;

	public Addhostel saveHostel(Addhostel hostel){
	    return repo.save(hostel);
	}

	public List<Addhostel> getAllHostels(){
	    return repo.findAll();
	}
  

}
