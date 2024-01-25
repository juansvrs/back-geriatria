package com.geriatria.app.service;


import com.geriatria.app.persistence.entity.ActividadEntity;
import com.geriatria.app.persistence.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    private final ActividadRepository actividadRepository;

    @Autowired

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository=actividadRepository;
    }

    /*public List<ActividadEntity> getAll(){
        return this.jdbcTemplate.query("SELECT * FROM actividad",new BeanPropertyRowMapper<>(ActividadEntity.class));
    }*/

    public List<ActividadEntity> getAll(){
        return this.actividadRepository.findAll();
    }

    public  ActividadEntity get(int idActividad){
        return this.actividadRepository.findById(idActividad).orElse(null);
    }

    public  ActividadEntity save(ActividadEntity actividad){
        return this.actividadRepository.save(actividad);
    }
    public void delete(int idactividad){
        this.actividadRepository.deleteById(idactividad);
    }

    public boolean exists(int idActividad){
        return actividadRepository.existsById(idActividad);
    }
}


