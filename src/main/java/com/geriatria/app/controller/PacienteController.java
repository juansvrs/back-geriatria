package com.geriatria.app.controller;

import com.geriatria.app.persistence.entity.PacienteEntity;
import com.geriatria.app.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    Logger logger = Logger.getLogger(PacienteController.class.getName());

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteEntity>> getAll() {
        return ResponseEntity.ok(this.pacienteService.getAll());
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<PacienteEntity> get(@PathVariable String idPaciente) {
        return ResponseEntity.ok(this.pacienteService.get(idPaciente));
    }

    @PostMapping()
    public ResponseEntity<PacienteEntity> add(@RequestBody PacienteEntity paciente) {
        logger.warning("Entra al metodo en el serivico");
        /*if (paciente.getIdPaciente() == null || this.pacienteService.exists(paciente.getIdPaciente())) {
            logger.warning("Entra al condicional del addPaciente");

            return ResponseEntity.ok(this.pacienteService.save(paciente));
        }*/
        return ResponseEntity.ok(this.pacienteService.save(paciente));

        //return ResponseEntity.badRequest().build();
    }

    @PutMapping()
    public ResponseEntity<PacienteEntity> update(@RequestBody PacienteEntity paciente) {
        if (paciente.getIdPaciente() != null && this.pacienteService.exists(paciente.getIdPaciente())) {
            return ResponseEntity.ok(this.pacienteService.save(paciente));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Void> delete(@PathVariable String idPaciente) {
        if (this.pacienteService.exists(idPaciente)) {
            this.pacienteService.delete(idPaciente);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/asc")
    public ResponseEntity<List<PacienteEntity>> getAllByNombreAsc() {
        return ResponseEntity.ok(this.pacienteService.getAllByNombreAsc());
    }

    @GetMapping("/desc")
    public ResponseEntity<List<PacienteEntity>> getAllByNombreDesc() {
        return ResponseEntity.ok(this.pacienteService.getAllByNombreDesc());
    }

}