package my.hospital.gov.restappointmentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
