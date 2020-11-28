package com.cieba.biblio.repository;

import com.cieba.biblio.model.LibroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository<LibroEntity, Long> {
}
