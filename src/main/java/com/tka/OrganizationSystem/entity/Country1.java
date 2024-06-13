package com.tka.OrganizationSystem.entity;


import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	
	
	public Country1() {
		
	}
	
	public Country1(String cname) {
		super();
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Country1 [cid=" + cid + ", cname=" + cname + "]";
	}
	
	

}
