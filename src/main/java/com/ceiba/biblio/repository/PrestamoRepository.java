/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.repository;

import com.ceiba.biblio.model.LibroEntity;
import com.ceiba.biblio.model.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author angie.jaramillo
 */
@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {

    List<PrestamoEntity> findByLibId(LibroEntity libro);

}
