package com.broadridge.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String name;
    
    private String email;
    
    private String phoneNumber;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Preferences preferences;

}
