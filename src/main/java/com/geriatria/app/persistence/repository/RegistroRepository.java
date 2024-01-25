package com.geriatria.app.persistence.repository;

import com.geriatria.app.persistence.entity.RegistroEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface RegistroRepository extends ListCrudRepository<RegistroEntity,String > {
}
