package com.geriatria.app.controller;


import com.geriatria.app.persistence.entity.PacienteActividadEntity;
import com.geriatria.app.persistence.entity.PacienteActividadId;
import com.geriatria.app.persistence.entity.PacienteEntity;
import com.geriatria.app.service.PacienteActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacienteactividad")
public class PacienteActividadController {

    private final PacienteActividadService pacienteActividadService;

    @Autowired
    public PacienteActividadController(PacienteActividadService pacienteActividadService) {
        this.pacienteActividadService = pacienteActividadService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteActividadEntity>> getAll() {
        return ResponseEntity.ok(this.pacienteActividadService.getAll());
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<List<PacienteActividadEntity>> get(@PathVariable String idPaciente) {
        return ResponseEntity.ok(this.pacienteActividadService.getActividadesByIdPaciente(idPaciente));
    }

    @PostMapping()
    public ResponseEntity<PacienteActividadEntity> add(@RequestBody PacienteActividadEntity pacienteActividad) {
            return ResponseEntity.ok(this.pacienteActividadService.save(pacienteActividad));
    }

    @DeleteMapping("/{idPaciente}/{idActividad}")
    public ResponseEntity<Void> delete(@PathVariable String idPaciente, @PathVariable Integer idActividad) {
            PacienteActividadId llave  = new PacienteActividadId(idActividad,idPaciente);
            this.pacienteActividadService.delete(llave);
            return ResponseEntity.ok().build();

    }

}