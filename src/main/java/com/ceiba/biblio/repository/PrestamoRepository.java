/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.repository;

import com.ceiba.biblio.model.LibroEntity;
import com.ceiba.biblio.model.PrestamoEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angie.jaramillo
 */
@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
    
    List<PrestamoEntity> findByLibId(LibroEntity libro);
    
}
