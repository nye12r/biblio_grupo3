package com.ceiba.biblio.repository;

import com.ceiba.biblio.model.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

    Optional<LibroEntity> findByIsbn(String isbn);


}
