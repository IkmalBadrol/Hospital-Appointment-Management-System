package my.hospital.gov.restappointmentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * This class is to represent the hospital menu after log in to the system
 */
@Controller
public class MainMenuController {
	
	@GetMapping("/mainmenu")
	public String showMenuPage(Model model)
	{
		
		return "mainmenu";
	}


}
