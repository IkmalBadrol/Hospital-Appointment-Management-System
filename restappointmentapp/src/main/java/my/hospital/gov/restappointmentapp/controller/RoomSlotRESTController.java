package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;
import my.hospital.gov.restappointmentapp.repository.RoomSlotRepository;

@RestController
@RequestMapping("/api/roomslots")
public class RoomSlotRESTController {

	@Autowired
	private RoomSlotRepository roomSlotRepository;
	
	@GetMapping
	public List<RoomSlot> getRoomSlots(){		
		return roomSlotRepository.findAll();
	}
	
	// Find available date
	@GetMapping("/{date}")
	public List<RoomSlot> findByDate(@PathVariable String date){
		return roomSlotRepository.findByDate(date);
	}
	
	
	
//	// Validate patient IC Number to proceed for appointment
//	@GetMapping("/roomID/{roomID}")
//	public RoomSlot findByRoomID(@PathVariable String roomID) {
//		
//		return roomSlotRepository.findByRoomID(roomID);
//	}
	
}
