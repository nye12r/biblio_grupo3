package com.ceiba.biblio.repository;

import com.ceiba.biblio.model.LibroEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

    Optional<LibroEntity> findByIsbn(String isbn);


}
