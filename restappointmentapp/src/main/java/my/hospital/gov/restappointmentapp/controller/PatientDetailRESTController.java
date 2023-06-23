package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.repository.PatientDetailRepository;

@RestController
@RequestMapping("/api/patientdetails")
public class PatientDetailRESTController {
	
	@Autowired
	private PatientDetailRepository patientDetailRepository;
	
	@GetMapping("{patientID}")
	public PatientDetail getPatientDetail(@PathVariable long patientID )
	{
		PatientDetail patientDetail=patientDetailRepository.findById(patientID).get();
		return patientDetail;
		
	}

	@GetMapping
	public List<PatientDetail> getPatientDetails()
	{
		return patientDetailRepository.findAll();
	}
	
	
	@PostMapping()
	public PatientDetail insertPatientDetail(@RequestBody PatientDetail patientDetail)
	{
		return patientDetailRepository.save(patientDetail);
	}
	
	
	@PutMapping()
	public PatientDetail updatePatientDetail(@RequestBody PatientDetail patientDetail)
	{
		return patientDetailRepository.save(patientDetail);
	}
	
	
	@DeleteMapping("{patientID}")
	public ResponseEntity<HttpStatus> deletePatientDetail(@PathVariable long patientID)
	{
		patientDetailRepository.deleteById(patientID);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	// Validate patient IC Number to proceed for appointment
	@GetMapping("/patientIC/{patientICNumber}")
	public PatientDetail findPatientByIC(@PathVariable String patientICNumber) {
		
		return patientDetailRepository.findPatientByIC(patientICNumber);
	}
	

	
	
}
