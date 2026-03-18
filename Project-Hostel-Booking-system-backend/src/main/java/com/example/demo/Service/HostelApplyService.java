package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.HostelApplyRepo;
import com.example.demo.entity.HostelApplication;

@Service
public class HostelApplyService {
    @Autowired
    private HostelApplyRepo repo;

    public HostelApplication saveApplication(HostelApplication app) {
        return repo.save(app);
    }
    public List<HostelApplication> getAllApplications(){
        return repo.findAll();
    }
	
	
	public void deleteApplication(String applicationId) {
		 repo.deleteById(applicationId);
	}
      
	public HostelApplication updateStatus(String applicationId, String status) {

	    HostelApplication app = repo.findById(applicationId).orElse(null);

	    if(app != null){
	        app.setStatus(status);
	        return repo.save(app);
	    }

	    return null;
	}

}
