package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

public class HostelApplicationRequest {
	
	 private String firstname;
	    private String lastname;
	    private String dob;
	    private String mobile;
	    private String email;
	    private String address;
	    private String education;
	    private String currentstatus;
	    private String hostelid;

	    private MultipartFile photo;
	    private MultipartFile signature;

	    public String getFirstname() { return firstname; }
	    public void setFirstname(String firstname) { this.firstname = firstname; }

	    public String getLastname() { return lastname; }
	    public void setLastname(String lastname) { this.lastname = lastname; }

	    public String getDob() { return dob; }
	    public void setDob(String dob) { this.dob = dob; }

	    public String getMobile() { return mobile; }
	    public void setMobile(String mobile) { this.mobile = mobile; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getAddress() { return address; }
	    public void setAddress(String address) { this.address = address; }

	    public String getEducation() { return education; }
	    public void setEducation(String education) { this.education = education; }

	    public String getCurrentstatus() { return currentstatus; }
	    public void setCurrentstatus(String currentstatus) { this.currentstatus = currentstatus; }

	    public String getHostelid() { return hostelid; }
	    public void setHostelid(String hostelid) { this.hostelid = hostelid; }

	    public MultipartFile getPhoto() { return photo; }
	    public void setPhoto(MultipartFile photo) { this.photo = photo; }

	    public MultipartFile getSignature() { return signature; }
	    public void setSignature(MultipartFile signature) { this.signature = signature; }
	
}
