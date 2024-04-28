package com.geriatria.app.persistence.repository;

import com.geriatria.app.persistence.entity.RegistroEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RegistroRepository extends ListCrudRepository<RegistroEntity,Long > {
    @Query("SELECT r FROM RegistroEntity r WHERE r.idPaciente = :idPaciente")
    List<RegistroEntity> findAllByPaciente(@Param("idPaciente") String idPaciente);

    @Query("SELECT r FROM RegistroEntity r WHERE r.idActividad = :idActividad")
    List<RegistroEntity> findAllByActividad(@Param("idActividad") Integer idActividad);

    @Query("SELECT r FROM RegistroEntity r WHERE r.idPaciente = :idPaciente AND r.idActividad = :idActividad")
    List<RegistroEntity> findAllByPacienteAndActividad(@Param("idPaciente") String idPaciente, @Param("idActividad") Integer idActividad);

    @Query("SELECT r FROM RegistroEntity r WHERE r.idPaciente = :idPaciente AND r.fecha = :fecha")
    List<RegistroEntity> findAllByPacienteAndFecha(@Param("idPaciente") String idPaciente, @Param("fecha") Date fecha);
}
