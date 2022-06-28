package com.wf.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.kafka.dao.SportsRepo;
import com.wf.kafka.model.Tutorial;

@Service
public class SportsService {
	
	@Autowired
	SportsRepo sportsRepo;
	
	public void saveData(Tutorial tutorial) {
		System.out.println("*** In saveData method >>>> ");
		try {
			sportsRepo.save(tutorial);
			System.out.println("Saved Tutorial Successfully....");
			if("Hyderabad".equalsIgnoreCase(tutorial.getLocation())) {
				tutorial.setLocation("Telangana - "+tutorial.getLocation());
	        	sportsRepo.save(tutorial);
	        	System.out.println("Updated Tutorial Successfully....");
	        }
		}
		catch(Exception exc) {
			System.out.println("Exception occured while saving the data ::: "+exc);
		}
		
		
	}

}
