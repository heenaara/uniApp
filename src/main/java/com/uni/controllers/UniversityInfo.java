package com.uni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.services.UniversityDetails;

@RestController
public class UniversityInfo {
	@Autowired
	UniversityDetails universityDetails;
	
	@PostMapping("checkUni")
	public String checkUni(@RequestParam(name="uni_name") String uni_name) {
		return universityDetails.checkUni(uni_name);
	}

}
