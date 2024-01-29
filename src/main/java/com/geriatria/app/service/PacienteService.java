package com.geriatria.app.service;

import com.geriatria.app.persistence.entity.ActividadEntity;
import com.geriatria.app.persistence.entity.PacienteEntity;
import com.geriatria.app.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository=pacienteRepository;
    }

    public List<PacienteEntity> getAll(){
        return this.pacienteRepository.findAll();
    }

    public  PacienteEntity get(String idPaciente){
        return this.pacienteRepository.findById(idPaciente).orElse(null);
    }

    public  PacienteEntity save(PacienteEntity paciente){
        return this.pacienteRepository.save(paciente);
    }
    public void delete(String idPaciente){
        this.pacienteRepository.deleteById(idPaciente);
    }

    public boolean exists(String idPaciente){
        return pacienteRepository.existsById(idPaciente);
    }


    public List<PacienteEntity> getAllByNombreAsc() {
        return this.pacienteRepository.findAllByOrderByNombreAsc();
    }

    public List<PacienteEntity> getAllByNombreDesc() {
        return this.pacienteRepository.findAllByOrderByNombreDesc();
    }

}


