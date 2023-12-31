package my.hospital.gov.restappointmentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.hospital.gov.restappointmentapp.model.PatientDetail;

/**
 * 
 * @author norbalqish
 *This class is the repository of patient
 *This class will validate existed patient using ICNumber
 */
@Repository
public interface PatientDetailRepository extends JpaRepository<PatientDetail, Long> {

//	@Query(value="select * from Patient e where e.patientName like%:keyword%",nativeQuery=true)
//	List<PatientDetail> findByKeyword(@Param("keyword") PatientDetail patientDetail);
//	
	
	// This method validate existed patient IC number 
	@Query(value = "select * from Patient where patientICNumber = :patientICNumber", nativeQuery = true)
	public PatientDetail findPatientByIC(@Param("patientICNumber") String patientICNumber);
	
}

