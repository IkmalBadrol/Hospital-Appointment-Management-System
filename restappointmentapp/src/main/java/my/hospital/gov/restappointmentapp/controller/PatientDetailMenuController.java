package my.hospital.gov.restappointmentapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;

import my.hospital.gov.restappointmentapp.model.PatientDetail;

/**
 * 
 * @author norbalqish
 * 
 * This class is to present the list of all patients
 * This class will present the specific patient details
 * This class will insert, update or delete patient
 */

@Controller
public class PatientDetailMenuController {

	private String defaultURI = "http://localhost:8080/appointmentapp/api/patientdetails";


	//Get patients list
	@GetMapping("/patientdetail/list")
	public String getPatientDetails(Model model,String keyword) {
	    String uriPatient = "http://localhost:8080/appointmentapp/api/patientdetails";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // Sends an HTTP GET request to the specified uriPatient
	    ResponseEntity<PatientDetail[]> response = 
	    		restTemplate.getForEntity(uriPatient, PatientDetail[].class);
	    
	    PatientDetail[] patientDetails = response.getBody();
	    
	    // Converts the array of PatientDetail objects to a List by using the Arrays.asList() method
	    List<PatientDetail> patientDetailList = Arrays.asList(patientDetails);
	    
	    // This model is used to pass data from the controller to the view.
	    model.addAttribute("patientDetails", patientDetailList);
	    
	    return "patientdetails";
	}
	
	
	// Insert patients' details
	@GetMapping("/patientdetail/{patientID}")
	public String getPatientDetail(@PathVariable Integer patientID, Model model)
	{
		/* 
		 * this method get patient detail
		 * @param patientID
		 * @param model
		 * @return
		 */
		String pageTitle="New Patient";
		PatientDetail patientDetail=new PatientDetail();

		// Check existence of patient's ID
		if(patientID>0)
		{
			//Generate new uri and append patientID to it
			String uriPatient=defaultURI+"/"+patientID;
			
			RestTemplate restTemplate=new RestTemplate();
			patientDetail=restTemplate.getForObject(uriPatient, PatientDetail.class);
			
			//Give new title to page
			pageTitle="Edit Patient Detail";
			
		}
		
		model.addAttribute("patientDetail",patientDetail);
		model.addAttribute("pageTitle",pageTitle);
		
		return "patientdetailinfo";	
	}
	
	
	// Save patient details into database
	@RequestMapping("/patientdetail/save")
	public String updatePatientDetail(@ModelAttribute PatientDetail patientDetail) throws Exception
	{
		/*
		 * This method will update or add new patient detail
		 */
		
		RestTemplate restTemplate=new RestTemplate();
		
		HttpEntity<PatientDetail> request  = 
				new HttpEntity<PatientDetail>(patientDetail);
		
		String patientDetailResponse="";
		
		// This try and catch block check duplicate for patient's ic number 
		try {
			
			if(!Strings.isBlank(patientDetail.getPatientICNumber()) )
			{
				//This block will update patient detail				
				//PUT method
				restTemplate.put(defaultURI,request,PatientDetail.class);
				
			}
			else
			{
				// Add new patient if patient's IC are not registered			
				//POST request			
				patientDetailResponse=
						restTemplate.postForObject(defaultURI, request, String.class);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		System.out.println(patientDetailResponse);
		return "redirect:/patientdetail/list";
		
	}
	
	
	
	/*
	 * This method is to delete patient detail by using patient ID
	 * Only patient without appointment can be deleted
	 * @param patientID
	 */
	@RequestMapping("/patientdetail/delete/{patientID}")
	public String deletePatientDetail(@PathVariable Integer patientID)
	{
		String uriPatient=defaultURI+"/{patientID}";
		
		//Send DELETE request
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.delete(uriPatient, Map.of("patientID",Integer.toString(patientID)));
		
		return "redirect:/patientdetail/list";
		
	}
	
	

	
}
