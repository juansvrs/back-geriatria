package com.geriatria.app.persistence.repository;

import com.geriatria.app.persistence.entity.PacienteEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PacienteRepository extends ListCrudRepository<PacienteEntity,String> {

    List<PacienteEntity> findAllByOrderByNombreAsc();

    List<PacienteEntity> findAllByOrderByNombreDesc();

    List<PacienteEntity> findAllByOrderByIdPacienteDesc();

    List<PacienteEntity> findAllByOrderByIdPacienteAsc();
}
