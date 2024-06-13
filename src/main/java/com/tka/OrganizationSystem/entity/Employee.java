package com.tka.OrganizationSystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int password;
	String name;
	String phoneno;
	String department;
	// he sales finance 
	String status;
	// data active inaactive suspend
	Date  createdddtm;
	String createdby;
	Date updateddtm;
	String updatedby;
	
	@ManyToOne(fetch =  FetchType.EAGER)
	@JoinColumn(name = "cid")
	Country1 country;

	

	

		
}
