package com.example.demo.entity;





import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Hostels_List")
public class Addhostel {

    @Id
    private String hostelid;

    private String hostelname;
    
    private LocalDate dob;
    private String area;

    private String facilities;

    private String contact;

    private Double charges;

    public Addhostel() {}

    public String getHostelid() {
        return hostelid;
    }

    public void setHostelid(String hostelid) {
        this.hostelid = hostelid;
    }

    public String getHostelname() {
        return hostelname;
    }

    public void setHostelname(String hostelname) {
        this.hostelname = hostelname;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }
    

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Addhostel [hostelid=" + hostelid + ", hostelname=" + hostelname + ", dob=" + dob + ", area=" + area
				+ ", facilities=" + facilities + ", contact=" + contact + ", charges=" + charges + "]";
	}



	public Addhostel(String hostelid, String hostelname, LocalDate dob, String area, String facilities, String contact,
			Double charges) {
		super();
		this.hostelid = hostelid;
		this.hostelname = hostelname;
		this.dob = dob;
		this.area = area;
		this.facilities = facilities;
		this.contact = contact;
		this.charges = charges;
	}
    
}
	
	
	

