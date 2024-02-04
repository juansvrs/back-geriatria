package com.geriatria.app.controller;

import com.geriatria.app.persistence.entity.RegistroEntity;
import com.geriatria.app.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    private final RegistroService registroService;

    @Autowired
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroEntity>> getAll() {
        return ResponseEntity.ok(this.registroService.getAll());
    }

    @GetMapping("/{idRegistro}")
    public ResponseEntity<RegistroEntity> get(@PathVariable Long idRegistro) {
        return ResponseEntity.ok(this.registroService.get(idRegistro));
    }

    @PostMapping()
    public ResponseEntity<RegistroEntity> add(@RequestBody RegistroEntity registroEntity) {
        return ResponseEntity.ok(this.registroService.save(registroEntity));
    }

    @PutMapping()
    public ResponseEntity<RegistroEntity> update(@RequestBody RegistroEntity registroEntity) {
        return ResponseEntity.ok(this.registroService.save(registroEntity));
    }

    @DeleteMapping("/{idRegistro}")
    public ResponseEntity<Void> delete(@PathVariable Long idRegistro) {
        this.registroService.delete(idRegistro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<RegistroEntity>> getAllByPaciente(@PathVariable String idPaciente) {
        return ResponseEntity.ok(this.registroService.getAllByPaciente(idPaciente));
    }

    @GetMapping("/actividad/{idActividad}")
    public ResponseEntity<List<RegistroEntity>> getAllByActividad(@PathVariable Integer idActividad) {
        return ResponseEntity.ok(this.registroService.getAllByActividad(idActividad));
    }

    @GetMapping("/paciente/{idPaciente}/actividad/{idActividad}")
    public ResponseEntity<List<RegistroEntity>> getAllByPacienteAndActividad(@PathVariable String idPaciente, @PathVariable Integer idActividad) {
        return ResponseEntity.ok(this.registroService.getAllByPacienteAndActividad(idPaciente, idActividad));
    }

    //Podria hacer una ruta para obtener los registros de un paciente en una fecha especifica
}
