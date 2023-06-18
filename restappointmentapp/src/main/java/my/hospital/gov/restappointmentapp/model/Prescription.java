package my.hospital.gov.restappointmentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "prescription")
public class Prescription {

	@Id
	@Column (name = "prescriptionID")
	private String prescriptionID;
	@Column (name = "medicine")
	private String medicineName;
	
	
	public String getPrescriptionID() {
		return prescriptionID;
	}
	public void setPrescriptionID(String prescriptionID) {
		this.prescriptionID = prescriptionID;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	
}
