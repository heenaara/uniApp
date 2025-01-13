package com.uni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uni.models.ResponseUniveristy;

@Service
public class UniversityDetails {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${get.uni.url}")
	String getUniUrlString;
	
	private ResponseUniveristy[] getUniversities(String countryName) {
		ResponseUniveristy[] response= restTemplate.getForObject(getUniUrlString+countryName, ResponseUniveristy[].class);
		return response;
		
	}
	public String checkUni(String name) {
		
		ResponseUniveristy[] response=getUniversities("United-States");
		
		for(ResponseUniveristy university : response) {
			if(university.getName().equals(name)) {
				return "The university "+name+" is located in United-States";
			}
		}
		return "The university "+name+" is not located in United-States";
		
	}
}
