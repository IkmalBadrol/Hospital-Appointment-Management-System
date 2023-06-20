package my.hospital.gov.restappointmentapp.controller;
import java.util.List;
import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.hospital.gov.restappointmentapp.model.PatientAppointment;
import my.hospital.gov.restappointmentapp.model.PatientDetail;
import my.hospital.gov.restappointmentapp.model.RoomSlot;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

@Controller
public class MonitoringController {
    private RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8080/appointment/data";

    @GetMapping("/appointment/data")
    public void fetchDataAndAssignVariables() {
        ResponseEntity<List<PatientAppointment>> response = restTemplate.exchange(
            BASE_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<PatientAppointment>>() {}
        );

        List<PatientAppointment> dataList = response.getBody();

        // Iterate over the dataList and save the values to separate variables
        for (PatientAppointment data : dataList) {
            PatientDetail patientID = data.getPatientID();
            Date date = data.getDate();
            RoomSlot roomslotID = data.getRoomSlotID();

            // Do further processing with the variables
            // ...
        }
    }
}
