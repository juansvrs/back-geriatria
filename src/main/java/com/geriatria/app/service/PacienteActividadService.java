package com.geriatria.app.service;

import com.geriatria.app.persistence.entity.PacienteActividadEntity;
import com.geriatria.app.persistence.entity.PacienteActividadId;
import com.geriatria.app.persistence.repository.PacienteActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteActividadService {
    private final PacienteActividadRepository pacienteActividadRepository;

    @Autowired
    public PacienteActividadService(PacienteActividadRepository pacienteActividadRepository) {
        this.pacienteActividadRepository = pacienteActividadRepository;
    }

    public List<PacienteActividadEntity> getAll() {
        return this.pacienteActividadRepository.findAll();
    }

    public List<PacienteActividadEntity> getActividadesByIdPaciente(String idPaciente){
        return this.pacienteActividadRepository.findActividadesByIdPaciente(idPaciente);
    }

    public PacienteActividadEntity save(PacienteActividadEntity pacienteActividad){
        return this.pacienteActividadRepository.save(pacienteActividad);
    }
    public void delete(PacienteActividadId pacienteActividadId){
        this.pacienteActividadRepository.deleteById(pacienteActividadId);
    }


}


