package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Prescription;
import za.ac.cput.service.PrescriptionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("PharmacySystem/prescription")
@Slf4j
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService){
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("save")
    public ResponseEntity<Prescription> save(@Valid @RequestBody Prescription prescription){
        log.info("save request:{}", prescription);
        Prescription save = prescriptionService.save(prescription);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{prescID}")
    public ResponseEntity<Prescription> read (@PathVariable String prescID){
        log.info("read request:{}", prescID);
        Prescription prescription = this.prescriptionService.read(prescID);
        return ResponseEntity.ok(prescription);
    }

    @DeleteMapping("delete/{prescID}")
    public ResponseEntity<Prescription> delete (@PathVariable String prescID){
        log.info("Read request:{}", prescID);
        this.prescriptionService.delete(prescID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Prescription>>findAll(){
        List<Prescription>prescriptionList = this.prescriptionService.getAll();
        return ResponseEntity.ok(prescriptionList);
    }
}
