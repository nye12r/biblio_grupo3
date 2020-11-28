package com.ceiba.biblio.repository;

import com.ceiba.biblio.model.LibroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends CrudRepository<LibroEntity, Long> {

    Optional<LibroEntity> findByIsbn(String isbn);


}
