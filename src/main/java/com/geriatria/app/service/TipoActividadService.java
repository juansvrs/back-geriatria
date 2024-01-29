package com.geriatria.app.service;

import com.geriatria.app.persistence.entity.PacienteEntity;
import com.geriatria.app.persistence.entity.TipoActividadEntity;
import com.geriatria.app.persistence.repository.PacienteRepository;
import com.geriatria.app.persistence.repository.TipoActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoActividadService {

    private final TipoActividadRepository tipoActividadRepository;

    @Autowired
    public TipoActividadService(TipoActividadRepository tipoActividadRepository) {
        this.tipoActividadRepository=tipoActividadRepository;
    }

    public List<TipoActividadEntity> getAll(){
        return this.tipoActividadRepository.findAll();
    }

    public  TipoActividadEntity get(Long idTipoActividad){
        return this.tipoActividadRepository.findById(idTipoActividad).orElse(null);
    }

    public  TipoActividadEntity save(TipoActividadEntity tipoActividad){
        return this.tipoActividadRepository.save(tipoActividad);
    }
    public void delete(Long idTipoActividad){
        this.tipoActividadRepository.deleteById(idTipoActividad);
    }

    public boolean exists(Long idTipoActividad){
        return this.tipoActividadRepository.existsById(idTipoActividad);
    }
}
