package com.geriatria.app.persistence.repository;

import com.geriatria.app.persistence.entity.ActividadEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ActividadRepository extends ListCrudRepository<ActividadEntity,Integer> {
}
