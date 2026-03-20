package com.example.demo.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Repository.HostelApplyRepo;
import com.example.demo.Service.HostelApplyService;
import com.example.demo.dto.HostelApplicationRequest;
import com.example.demo.entity.HostelApplication;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://hbs-frontend-2ujh.onrender.com")
public class HostelApplyController {

    @Autowired
    private HostelApplyService service;
    
 
    
    @Autowired
    private HostelApplyRepo repo;
    
    @PostMapping("/apply")
    public ResponseEntity<?> saveApplication(@ModelAttribute HostelApplicationRequest req) {

        try {

            LocalDate date = LocalDate.parse(req.getDob());

            String uploadDir = "uploads/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String photoName = System.currentTimeMillis() + "_" + req.getPhoto().getOriginalFilename();
            Files.copy(req.getPhoto().getInputStream(),
                    uploadPath.resolve(photoName),
                    StandardCopyOption.REPLACE_EXISTING);

            String signName = System.currentTimeMillis() + "_" + req.getSignature().getOriginalFilename();
            Files.copy(req.getSignature().getInputStream(),
                    uploadPath.resolve(signName),
                    StandardCopyOption.REPLACE_EXISTING);

            long count = repo.count() + 1;
            String applicationId = "APP2026" + String.format("%03d", count);

         

            HostelApplication app = new HostelApplication();

            app.setApplicationId(applicationId);
           
            app.setFirstname(req.getFirstname());
            app.setLastname(req.getLastname());
            app.setDob(date);
            app.setMobile(req.getMobile());
            app.setEmail(req.getEmail());
            app.setAddress(req.getAddress());
            app.setEducation(req.getEducation());
            app.setCurrentstatus(req.getCurrentstatus());
            app.setPhoto(photoName);
            app.setSignature(signName);

            repo.save(app);

            Map<String,String> response = new HashMap<>();
            response.put("applicationId", applicationId);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving application");
        }
    }
    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {

        String applicationId = loginData.get("applicationId");
        String dobString = loginData.get("dob"); // e.g., "2000-01-15"

        // Convert String to LocalDate
        LocalDate dob = LocalDate.parse(dobString); // default format: yyyy-MM-dd

        // Now call the repo with correct type
        HostelApplication user = repo.findByApplicationIdAndDob(applicationId, dob);

        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid Hostel ID or DOB");
        }

        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/applications")
    public List<HostelApplication> getApplications(){
        return service.getAllApplications();
    }
   
    @DeleteMapping("/application/{applicationId}")
    public String deleteApplication(@PathVariable String applicationId) {
    	service.deleteApplication(applicationId);
    	return "Application deleted Successfully";
    }
    
    @PutMapping("/application/{applicationId}/approve")
    public HostelApplication approveApplication(@PathVariable String applicationId){
        return service.updateStatus(applicationId,"Approved");
    }

 
    @PutMapping("/application/{applicationId}/reject")
    public HostelApplication rejectApplication(@PathVariable String applicationId){
        return service.updateStatus(applicationId,"Rejected");
    }
}