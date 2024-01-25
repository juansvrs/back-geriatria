package com.geriatria.app.persistence.repository;

import com.geriatria.app.persistence.entity.PacienteActividadEntity;
import com.geriatria.app.persistence.entity.PacienteActividadId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteActividadRepository extends ListCrudRepository<PacienteActividadEntity, PacienteActividadId> {

    @Query(value = "SELECT pa FROM PacienteActividadEntity pa WHERE pa.idPaciente = :idPaciente")
    List<PacienteActividadEntity> findActividadesByIdPaciente(@Param("idPaciente") String idPaciente);
}
