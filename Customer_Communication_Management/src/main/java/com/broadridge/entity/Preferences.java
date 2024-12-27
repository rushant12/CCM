package com.broadridge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Preferences {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private boolean EmailOptIn;
	
	private boolean smsOptIn;
	
	private boolean pushOptIn;
	
	

}
