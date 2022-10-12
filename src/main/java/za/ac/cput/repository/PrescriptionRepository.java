package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,String> {


}
