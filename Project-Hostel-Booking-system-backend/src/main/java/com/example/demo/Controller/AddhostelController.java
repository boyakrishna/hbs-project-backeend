package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Repository.AddhostelRepo;
import com.example.demo.Service.AddhostelService;
import com.example.demo.entity.Addhostel;


import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AddhostelController {

    @Autowired
    private AddhostelRepo repo;

    @Autowired
    private AddhostelService service;


    // ADD HOSTEL
    @PostMapping("/addhostel")
    public Map<String,String> saveApplication(@RequestBody Addhostel addhostel){

        long count = repo.count() + 1;

        String hostelid = "HSTL2026" + String.format("%03d", count);

        addhostel.setHostelid(hostelid);

        repo.save(addhostel);

        Map<String, String> response = new HashMap<>();
        response.put("hostelid", hostelid);

        return response;
    }


    @PostMapping("/adminlogin")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {

        String hostelid = loginData.get("hostelid");
        String dobString = loginData.get("dob"); // e.g., "2000-01-15"

        // Convert String to LocalDate
        LocalDate dob = LocalDate.parse(dobString); // default format: yyyy-MM-dd

        // Now call the repo with correct type
        Addhostel user = repo.findByHostelidAndDob(hostelid, dob);

        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid Hostel ID or DOB");
        }

        return ResponseEntity.ok(user);
    }


    // GET HOSTELS
    @GetMapping("/hostels")
    public List<Addhostel> getHostels(){
        return service.getAllHostels();
    }
    
   

}