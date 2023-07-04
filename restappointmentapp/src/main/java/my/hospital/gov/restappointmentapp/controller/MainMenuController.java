package my.hospital.gov.restappointmentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author norbalqish
 *This class is to present the main menu of the program
 */
@Controller
public class MainMenuController {
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/mainmenu")
	public String showMenuPage(Model model)
	{
		
		return "mainmenu";
	}


}
