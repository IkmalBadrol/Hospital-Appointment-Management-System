package my.hospital.gov.restappointmentapp.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.http.HttpEntity;

import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;

@Controller
public class PatientAppointmentScheduleController {

	
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
	
	
	/**
	 * This method will update or add patient appointment
	 * 
	 * @param patientAppointment
	 * @return
	 */
	@RequestMapping("/appointments/save")
	public String updatePatientAppointment (@ModelAttribute PatientAppointment patientAppointment)
	{
		//Create a new RestTemplate 
		// HTTP request
		RestTemplate restTemplateAppointment = new RestTemplate();
		
		//Create request body
		HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(patientAppointment);
		
		// Initialize empty String
		String patientAppointmentResponse = "";
		
		
		// Check if appointment id existed
		if(patientAppointment.getAppointmentID()> 0)
		{
			// This block update a new order type and
			// Send request as PUT and update appointment
			restTemplateAppointment.put(defaultURI, request, PatientAppointment.class);
			
		}else {
			//This block add a new order type
			//Send request as POST
			patientAppointment.setTreatmentStatus("Pending");
			patientAppointmentResponse = restTemplateAppointment.postForObject(defaultURI, request, String.class);
			
			
		}
		
		System.out.println(patientAppointmentResponse);
		
		//Redirect request to display a list of appointment list
		return "redirect:/appointments/appointmentList";
		
	}
	
//	@RequestMapping("/appointment/Status/{appointmentID}")
//	public String updateStatusAppointment(@ModelAttribute PatientAppointment patientAppointment) {
//		
//		//Create a new RestTemplate 
//		// HTTP request
//		RestTemplate restTemplateStatusAppointment = new RestTemplate();
//				
//		//Create request body
//		HttpEntity<PatientAppointment> request = new HttpEntity<PatientAppointment>(patientAppointment);
//		
//		// Initialize empty String
//		String StatusAppointmentResponse = "";
//		
//		patientAppointment.setTreatmentStatus("Finished");
//		StatusAppointmentResponse = restTemplateStatusAppointment.postForObject(defaultURI, request, String.class);
//		
//		return "appointmentRoom1";
//		
//				
//	}
	

	/**
	 * validate patient IC number
	 * this method will retrieve data from database
	 * 
	 * @param patientIC
	 * @param model
	 * @param patientIC1
	 * @return
	 */
	@GetMapping("/appointments/{patientIC}")
	public String getAppointment(@PathVariable String patientIC,  Model model, 
			@RequestParam(name = "patientIC1", required =false) String patientIC1, 
			@RequestParam(name = "date", required =false)String date) {
		
		String pageTitle="Appointment";
		
		PatientAppointment patientAppointment = new PatientAppointment();
		
		PatientDetail currentPatientDetail = new PatientDetail();
			
		if(!Strings.isBlank(patientIC1)) {
			//String uri = defaultURI + "/" +patientIC;
			
			RestTemplate restPatient = new RestTemplate();
			currentPatientDetail = restPatient.getForObject("http://localhost:8080/appointmentapp/api/patientdetails/patientIC/" 
			+ patientIC1, PatientDetail.class);	
			patientAppointment.setPatientID(currentPatientDetail);			
		}
		
		
		
		// Get available date
		String uri ="http://localhost:8080/appointmentapp/api/roomslots";
		
		
		// Check if date in null 
		// and parse date into patientAppointemnt Object
			if(!Strings.isBlank(date)) {
				uri += "/"+ date;
				patientAppointment.setDate(Date.valueOf(date));
			}
		
		
		
		
	
		RestTemplate restTemplateRoomSlot = new RestTemplate();
		ResponseEntity<RoomSlot[]> responseRoomSlot = restTemplateRoomSlot.getForEntity(uri, RoomSlot[].class);
		
		RoomSlot roomSlotArray[] = responseRoomSlot.getBody();
		
		List<RoomSlot>slotList = Arrays.asList(roomSlotArray);
		
		for( RoomSlot roomslot : slotList) {
			
			System.out.println("test data" + roomslot.getRoomID().getDoctorID());
		}
			
		
//		RestTemplate restTemplateDoctor = new RestTemplate();
//		ResponseEntity<Doctor[]> responseDoctor = restTemplateDoctor.getForEntity("http://localhost:8080/appointmentapp/api/doctors", Doctor[].class);
//		
//		Doctor doctorArray[] = responseDoctor.getBody();
//		
//		List<Doctor>doctorList = Arrays.asList(doctorArray);
		
		
	    // pass object into html 
		model.addAttribute("patientAppointment", patientAppointment);
		model.addAttribute("Appointment",pageTitle);
		model.addAttribute("patientID", currentPatientDetail);
		model.addAttribute("slotList", slotList);
		//model.addAttribute("AppointmentList", AppointmentList);
		//model.addAttribute("roomList", roomList);
		//model.addAttribute("doctorList", doctorList);
		
		return "appointment";
	}
	
	/**
	 * This method retrieve data of appointments 
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/appointments/appointmentList")
	public String getAppointmentsList(Model model) {
		
		//The URI for GET Doctors
		String uri = "http://localhost:8080/appointmentapp/api/appointments";
		
		//Get a list doctors from the web services
		RestTemplate restTemplateAppointmentsList = new RestTemplate();
		ResponseEntity<PatientAppointment[]> response = restTemplateAppointmentsList.getForEntity(uri, PatientAppointment[].class);
		
		//Parse JSON data to array of object  
		PatientAppointment appointmentList[] = response.getBody();
		
		//Parse an array to a list object
		List<PatientAppointment> apptList = Arrays.asList(appointmentList);
		
		//Attach list to model as attribute
		model.addAttribute("apptList", apptList);
		
		return "appointmentlist";
	}

	

	
//	@GetMapping("/appointments/doctor")
//	public String getDoctorAppointment(Model model) {
//		//String uri = "http://localhost:8080/appointmentapp/api/appointments";
//		
//		//PatientAppointment patientAppointment = new PatientAppointment();
//		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<PatientAppointment[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/appointmentapp/api/appointments", PatientAppointment[].class);
//		
//		PatientAppointment patientAppointments[] = responseEntity.getBody();
//		
//		List<PatientAppointment> AppointmentList = Arrays.asList(patientAppointments);
//		
//		for( PatientAppointment appointment : AppointmentList) {
//			
//			System.out.println("test data" + appointment.getRoomSlotID().getRoomID().getDoctorID().getDoctorName());
//		}
//	
//		
//		
//		RestTemplate restTemplateRoomSlot = new RestTemplate();
//		ResponseEntity<RoomSlot[]> responseRoomSlot = restTemplateRoomSlot.getForEntity("http://localhost:8080/appointmentapp/api/roomslots", RoomSlot[].class);
//		
//		RoomSlot roomSlotArray[] = responseRoomSlot.getBody();
//		
//		List<RoomSlot>slotList = Arrays.asList(roomSlotArray);
//		
//		
//		
//		RestTemplate restTemplateRoom = new RestTemplate();
//		ResponseEntity<Room[]> responseRoom = restTemplateRoom.getForEntity("http://localhost:8080/appointmentapp/api/rooms", Room[].class);
//		
//		Room roomArray[] = responseRoom.getBody();
//		
//		List<Room>roomList = Arrays.asList(roomArray);
//		
//for( PatientAppointment appointment : AppointmentList) {
//			
//			System.out.println("test data" + appointment.getRoomSlotID().getRoomID().getDoctorID().getDoctorName());
//		}
//
//		
//		
//		
//		RestTemplate restTemplateDoctor = new RestTemplate();
//		ResponseEntity<Doctor[]> responseDoctor = restTemplateDoctor.getForEntity("http://localhost:8080/appointmentapp/api/doctors", Doctor[].class);
//		
//		Doctor doctorArray[] = responseDoctor.getBody();
//		
//		List<Doctor>doctorList = Arrays.asList(doctorArray);
//		
//		//System.out.println(responseEntity.getAppointmentID());
//		
//		model.addAttribute("AppointmentList", AppointmentList);
//		model.addAttribute("slotList", slotList);
//		model.addAttribute("roomList", roomList);
//		model.addAttribute("doctorList", doctorList);
//				
//		return "appointment";
//	}
	
	
	
}
