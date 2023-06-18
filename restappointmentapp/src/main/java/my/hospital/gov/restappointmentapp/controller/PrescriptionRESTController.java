package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.Prescription;
import my.hospital.gov.restappointmentapp.repository.PrescriptionRepository;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionRESTController {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@GetMapping
	public List<Prescription> getPrescriptions(){
		return prescriptionRepository.findAll();
	}
	
//	public Prescription getPrescription(long prescriptionID) {
//		
//	}
//	
//	public Prescription insertPrescription(Prescription prescription) {
//		
//	}
//	
//	public Prescription updatePrescription(Prescription prescription) {
//		
//	}
//	
//	public ResponseEntity<HttpStatus> deletePrescription (long prescriptionID){
//		
//	}

}
