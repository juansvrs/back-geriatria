package com.geriatria.app.controller;

import com.geriatria.app.persistence.entity.ActividadEntity;
import com.geriatria.app.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService actividadService;

    @Autowired
    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping
    public ResponseEntity<List<ActividadEntity>> getAll(){
        return ResponseEntity.ok(this.actividadService.getAll());
    }

    @GetMapping("/{idActividad}")
    public ResponseEntity<ActividadEntity> get(@PathVariable int idActividad){
        return ResponseEntity.ok(this.actividadService.get(idActividad));
    }

    @PostMapping()
    public ResponseEntity<ActividadEntity> add(@RequestBody ActividadEntity actividad){
        if(actividad.getIdActividad()==null ||this.actividadService.exists(actividad.getIdActividad())){
            return ResponseEntity.ok(this.actividadService.save(actividad));
        }
        return  ResponseEntity.badRequest().build();

    }

    @PutMapping()
    public ResponseEntity<ActividadEntity> update(@RequestBody ActividadEntity actividad){
        if(actividad.getIdActividad() != null && this.actividadService.exists(actividad.getIdActividad())){
            return ResponseEntity.ok(this.actividadService.save(actividad));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idActividad}")
    public ResponseEntity<Void> delete(@PathVariable int idActividad){
        if (this.actividadService.exists(idActividad)){
            this.actividadService.delete(idActividad);
            return ResponseEntity.ok().build();

        }
        return ResponseEntity.badRequest().build();
    }

}
