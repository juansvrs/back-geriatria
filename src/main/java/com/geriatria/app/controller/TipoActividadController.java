package com.geriatria.app.controller;


import com.geriatria.app.persistence.entity.TipoActividadEntity;
import com.geriatria.app.service.TipoActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoactividad")
public class TipoActividadController {

    private final TipoActividadService tipoActividadService;

    @Autowired
    public TipoActividadController(TipoActividadService tipoActividadService) {
        this.tipoActividadService = tipoActividadService;
    }

    @GetMapping
    public ResponseEntity<List<TipoActividadEntity>> getAll(){
        return ResponseEntity.ok(this.tipoActividadService.getAll());
    }

    @GetMapping("/{idTipo}")
    public ResponseEntity<TipoActividadEntity> get(@PathVariable long idTopo){
        return ResponseEntity.ok(this.tipoActividadService.get(idTopo));
    }

    @PostMapping()
    public ResponseEntity<TipoActividadEntity> add(@RequestBody TipoActividadEntity tipoActividad){
        if(tipoActividad.getId()==null ||this.tipoActividadService.exists(tipoActividad.getId())){
            return ResponseEntity.ok(this.tipoActividadService.save(tipoActividad));
        }
        return  ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/{idTipoActividad}")
    public ResponseEntity<Void> delete(@PathVariable Long idTipoActividad){
        if (this.tipoActividadService.exists(idTipoActividad)){
            this.tipoActividadService.delete(idTipoActividad);
            return ResponseEntity.ok().build();

        }
        return ResponseEntity.badRequest().build();
    }

}
