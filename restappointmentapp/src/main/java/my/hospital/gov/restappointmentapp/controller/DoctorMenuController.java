package my.hospital.gov.restappointmentapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.hospital.gov.restappointmentapp.model.Doctor;

@Controller
public class DoctorMenuController {

	@GetMapping("/doctor/list")
	public ResponseEntity<String> getDoctors(){
		
		//URL = http://localhost:8080/appointmentapp/doctor/list
		
		//The URI for GET Doctors data
		String uri = "http://localhost:8080/appointmentapp/api/doctors";
		
		//Get a list Doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Doctor[]> response = restTemplate.getForEntity(uri, Doctor[].class);
		
		//Parse JSON data to array of object
		Doctor doctors[] = response.getBody();
	
		//Generate message
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Doctors Details " + doctors.length + "\n");
		
		//Display Doctors' information
		for(Doctor doctor:doctors) {
			System.out.println(doctor.getDoctorID());
			System.out.println(doctor.getDoctorName());
			System.out.println(doctor.getDoctorICNumber());
			System.out.println(doctor.getDoctorPhoneNum());
			System.out.println(doctor.getDoctorAge());
			System.out.println(doctor.getDoctorGender());
			System.out.println(doctor.getDoctorAddress());
		}
		
		//For Postman status
		String message = "Check message in console for Doctor's information";
		
		//Display message in web
		//ResponseEntity for message in http
		return new ResponseEntity<>(message, HttpStatus.OK);		
	}
	
	@GetMapping("/doctor/list-view")
	public String getDoctors(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/doctors";
		
		//Get a list doctors from the web services
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Doctor[]> response = restTemplate.getForEntity(uri, Doctor[].class);
		
		//Parse JSON data to array of object  
		Doctor doctors[] = response.getBody();
		
		//Parse an array to a list object
		List<Doctor> doctorList = Arrays.asList(doctors);
		
		//Attach list to model as attribute
		model.addAttribute("Doctors", doctorList);
		
		return "doctors";
	}
}
