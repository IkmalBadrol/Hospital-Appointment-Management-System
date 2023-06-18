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
import org.springframework.http.HttpEntity;

import my.hospital.gov.restappointmentapp.model.PatientDetail;

@Controller
public class PatientDetailMenuController {

	private String defaultURI = "http://localhost:8080/appointmentapp/api/patientdetails";


//	public <HttpStatus> ResponseEntity getPatientDetails()
//	{
//		
//		/*
//		 * This method is tho consume a GET webservice
//		 * and display list of record
//		 */
//		return null;
//		
//	}
	
	
//	@GetMapping("/patientdetail/list")
//	public ResponseEntity<String> getPatientDetails()
//	{
//		
//		//The URI for GET patient details
//		String uriPatient="http://localhost:8080/appointmentapp/api/patientdetails";
//		
//		//Get a list patient details from web service
//		RestTemplate restTemplate=new RestTemplate();		
//		ResponseEntity<PatientDetail[]> response=restTemplate.getForEntity(uriPatient, PatientDetail[].class);
//		PatientDetail patientDetails[]=response.getBody();
//		
//		System.out.println(this.getClass().getSimpleName());
//		System.out.println("Total records:"+patientDetails.length+"\n");
//		
//		
//		for(PatientDetail patientDetail:patientDetails)
//			{
//				System.out.print(patientDetail.getPatientID()+"-");
//				System.out.print(patientDetail.getPatientName()+"-");
//				System.out.print(patientDetail.getPatientICNumber()+"-");
//				System.out.println(patientDetail.getPatientPhoneNumber()+ "-");
//				System.out.print(patientDetail.getPatientAge()+"-");
//				System.out.print(patientDetail.getPatientGender()+"-");
//				System.out.println(patientDetail.getPatientAddress()+"-");
//			}
//		
//		
//		//for postman status
//		String message="Check out the message in the console";
//		return new ResponseEntity<>(message,HttpStatus.OK);
//	}
	
	
	@GetMapping("/patientdetail/list")
	public String getPatientDetails(Model model,String keyword) {
	    String uriPatient = "http://localhost:8080/appointmentapp/api/patientdetails";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<PatientDetail[]> response = restTemplate.getForEntity(uriPatient, PatientDetail[].class);
	    PatientDetail[] patientDetails = response.getBody();
	    List<PatientDetail> patientDetailList = Arrays.asList(patientDetails);
	    model.addAttribute("patientDetails", patientDetailList);
	    
	    
	    return "patientdetails";
	}
	
	
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
	
	
	@RequestMapping("/patientdetail/save")
	public String updatePatientDetail(@ModelAttribute PatientDetail patientDetail)
	{
		/*
		 * This method will update or add new patient detail
		 */
		
		RestTemplate restTemplate=new RestTemplate();
		
		HttpEntity<PatientDetail> request=new HttpEntity<PatientDetail>(patientDetail);
		
		String patientDetailResponse="";
		
		if(patientDetail.getPatientID()>0 )
		{
			//This block will update patient detail
			
			//PUT method
			restTemplate.put(defaultURI,request,PatientDetail.class);
			
		}
		else
		{
			//add new patient
			
			//POST request
			
			patientDetailResponse=restTemplate.postForObject(defaultURI, request, String.class);
		}
	System.out.println(patientDetailResponse);
		return "redirect:/patientdetail/list";
		
	}
	
	
	
	/*
	 * This method is to delete patient detail by using patient ID
	 * @param patientID
	 * @return
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
	
	@GetMapping("/patientdetail/search")
	public String searchPatientDetails(@RequestParam("keyword") String keyword, Model model) {
	    String uriPatient = "http://localhost:8080/appointmentapp/api/patientdetails/search?keyword=" + keyword;

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<PatientDetail[]> response = restTemplate.getForEntity(uriPatient, PatientDetail[].class);
	    PatientDetail[] patientDetails = response.getBody();
	    List<PatientDetail> patientDetailList = Arrays.asList(patientDetails);
	    model.addAttribute("patientDetails", patientDetailList);
	    model.addAttribute("searchKeyword", keyword);

	    return "patientdetails";
	}
	
}
