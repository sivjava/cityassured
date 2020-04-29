package com.example.demo;


public class City {

	
    private Long id;
	
         
    private String name;
     
    
    private String pincode;
    
   
    private String state;
    
    public City(Long id, String name, String pincode, String state) {
		super();
		this.id = id;
		this.name = name;
		this.pincode = pincode;
		this.state = state;
	}
    
    public City() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
     
    
	
}