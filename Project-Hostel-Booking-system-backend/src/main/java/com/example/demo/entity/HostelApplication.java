package com.example.demo.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="Applications_List")
public class HostelApplication {

    @Id
    @Column(name="application_id", nullable = false, unique = true)
    private String applicationId;
    
   
    
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String mobile;
    private String email;
    private String address;
    private String education;
    private String currentstatus;
    private String photo;
    private String signature;
    private String status = "Pending";
   
    public HostelApplication() {
    	
    }

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCurrentstatus() {
		return currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "HostelApplication [applicationId=" + applicationId +  ", firstname="
				+ firstname + ", lastname=" + lastname + ", dob=" + dob + ", mobile=" + mobile + ", email=" + email
				+ ", address=" + address + ", education=" + education + ", currentstatus=" + currentstatus + ", photo="
				+ photo + ", signature=" + signature + ",status=" + status +"]";
	}

	public HostelApplication(String applicationId,  String firstname, String lastname, LocalDate dob,
			String mobile, String email, String address, String education, String currentstatus, String photo,
			String signature,String status) {
		super();
		this.applicationId = applicationId;
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.education = education;
		this.currentstatus = currentstatus;
		this.photo = photo;
		this.signature = signature;
		this.status= status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




   
	
}