package com.geriatria.app.service;


import com.geriatria.app.persistence.entity.ActividadEntity;
import com.geriatria.app.persistence.entity.PacienteEntity;
import com.geriatria.app.persistence.entity.RegistroEntity;
import com.geriatria.app.persistence.repository.PacienteRepository;
import com.geriatria.app.persistence.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegistroService {
    private final RegistroRepository registroRepository;

    @Autowired
    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository=registroRepository;
    }

    public List<RegistroEntity> getAll(){
        return this.registroRepository.findAll();
    }

    public  RegistroEntity get(Long idRegistro){
        return this.registroRepository.findById(idRegistro).orElse(null);
    }

    public  RegistroEntity save(RegistroEntity registroEntity){
        return this.registroRepository.save(registroEntity);
    }
    public void delete(Long idRegistro){
        this.registroRepository.deleteById(idRegistro);
    }



    public List<RegistroEntity> getAllByPaciente(String idPaciente) {
        return this.registroRepository.findAllByPaciente(idPaciente);
    }

    public List<RegistroEntity> getAllByActividad(Integer idActividad) {
        return this.registroRepository.findAllByActividad(idActividad);
    }

    public List<RegistroEntity> getAllByPacienteAndActividad(String idPaciente, Integer idActividad) {
        return this.registroRepository.findAllByPacienteAndActividad(idPaciente, idActividad);
    }

    public List<RegistroEntity> getAllByPacienteAndFecha(String idPaciente, Date fecha) {
        return this.registroRepository.findAllByPacienteAndFecha(idPaciente, fecha);
    }

}


