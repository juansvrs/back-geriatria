package com.geriatria.app.persistence.repository;

import com.geriatria.app.persistence.entity.RegistroEntity;
import com.geriatria.app.persistence.entity.TipoActividadEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface TipoActividadRepository extends ListCrudRepository<TipoActividadEntity,Long > {
}
