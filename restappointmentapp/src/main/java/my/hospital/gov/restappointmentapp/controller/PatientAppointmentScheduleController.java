package my.hospital.gov.restappointmentapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;

import my.hospital.gov.restappointmentapp.model.Doctor;
import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;
import my.hospital.gov.restappointmentapp.model.Room;
import my.hospital.gov.restappointmentapp.repository.DoctorRepository;

@Controller
public class PatientAppointmentScheduleController {
	
	private PatientAppointment patientAppointment;
	private PatientDetail patientDetail;
	@Autowired
	private DoctorRepository doctorRepository;
	
	private String defaultURI = "http://localhost:8080/appointmentapp/api/appointments";

	//
	@GetMapping("/appointments/schedule")
	public String getPatientAppointments(Model model) {
		String uri = "http://localhost:8080/appointmentapp/api/appointments";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> responseEntity = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		PatientAppointment patientAppointments[] = responseEntity.getBody();
		
		List<PatientAppointment>patientAppointmentList = Arrays.asList(patientAppointments);
		
		model.addAttribute("patientAppointments", patientAppointmentList);
		
		return "appointment";
	}
	
	
	// @ModelAttribute will bind the incoming request data to patientAppointment
	// @RequestParam  retrieve appointmentID from request parameters
	@RequestMapping("/appointments/save")
	public String updatePatientAppointment (@ModelAttribute PatientAppointment patientAppointment, @RequestParam long appointmentID)
	{
		//Create a new RestTemplate 
		// HTTP request
		RestTemplate restTemplate = new RestTemplate();
		
		//Create request body
		HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(patientAppointment);
		
		// Initialize empty String
		String patientAppointmentResponse = "";
		
		
		// Check if appointment id existed
		if (appointmentID > 0)
		{
			// This block update a new order type and
			// Send request as PUT
			// Send request and update appointment
			// Updated appointment return as PatienAppointment object
			restTemplate.put(defaultURI + "/" + appointmentID, request, PatientAppointment.class);
			
		}else {
			//This block add a new order type
			//Send request as POST
			patientAppointmentResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(patientAppointmentResponse);
		
		//Redirect request to display a list of order type
		return "redirect:/appointment/save";
		
	}
	
//	@GetMapping
//	public String getPatientName(@ModelAttribute PatientDetail patientDetail, @RequestParam long patientName) {
//		
//		if(patientDetail.equals(patientName)) {
//			String uri = defaultURI + "/" +patientName;
//			
//			RestTemplate restTemplate = new RestTemplate();
//			patientDetail = restTemplate.getForObject(uri, PatientDetail.class);
//			
//		}
//	
//		model.addAtt
//	}
	
	
	// Validate patient IC Number
	@GetMapping("/appointments/{patientIC}")
	public String getAppointment(@PathVariable Integer patientIC,  Model model, 
			@RequestParam(name = "patientIC1", required =false) String patientIC1) {
		
		String pageTitle="Appointment";
		
		PatientAppointment patientAppointment = new PatientAppointment();
		
		PatientDetail currentPatientDetail = new PatientDetail();
			
		if(!Strings.isBlank(patientIC1)) {
			//String uri = defaultURI + "/" +patientIC;
			
			RestTemplate restPatient = new RestTemplate();
			currentPatientDetail = restPatient.getForObject("http://localhost:8080/appointmentapp/api/patientdetails/patientIC/" + patientIC1, PatientDetail.class);	
			patientAppointment.setPatientID(currentPatientDetail);
			
		}
		
		System.out.println(currentPatientDetail.getPatientID());
	    
		model.addAttribute("patientAppointment", patientAppointment);
		model.addAttribute("Appointment",pageTitle);
		model.addAttribute("patientID", currentPatientDetail);
		
		return "appointment";
	}
	
	
//	@GetMapping("/appointments/{doctorName}")
//	public String getDoctorName(@PathVariable String roomSlotID, @PathVariable String roomID, @PathVariable String doctorID,
//			@PathVariable String doctorName, Model model, @RequestParam(name = "doctorName1", required = false) String doctorName1) {
//	
//		PatientAppointment patientAppointment = new PatientAppointment();
////		RoomSlot roomSlot = new RoomSlot();
////		Room room = new Room();
//		Doctor doctor = new Doctor();
//		
//		if(!Strings.isBlank(doctorName1)) {
//			//String uri = defaultURI + "/" +patientIC;
//			
//			RestTemplate restRoomSlot = new RestTemplate();
//			RestTemplate restRoom = new RestTemplate();
//			RestTemplate restDoctor = new RestTemplate();
//			
//			doctor = restDoctor.getForObject("http://localhost:8080/appointmentapp/api/patientdetails/patientIC/" + doctorName1, Doctor.class);	
//			patientAppointment.getRoomSlotID().getRoomID().getDoctorID().getDoctorName();
//			
//		}
//		
//		model.addAttribute("doctor",doctor);
//		model.addAttribute("patientAppointment",patientAppointment);
//		
//		return "appointment";
//	}

	
	@GetMapping("/appointments/doctor")
	public String getDoctorAppointment(Model model) {
		String uri = "http://localhost:8080/appointmentapp/api/appointments";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PatientAppointment[]> responseEntity = restTemplate.getForEntity(uri, PatientAppointment[].class);
		
		PatientAppointment patientAppointments[] = responseEntity.getBody();
		
		List<PatientAppointment>doctorAppointmentList = Arrays.asList(patientAppointments);
		
		model.addAttribute("doctorAppointmentList", doctorAppointmentList);
		
		return "appointment";
	}
	
}
