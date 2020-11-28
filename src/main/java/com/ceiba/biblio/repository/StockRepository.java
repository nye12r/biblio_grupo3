/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceiba.biblio.repository;

import com.ceiba.biblio.model.StockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angie.jaramillo
 */
@Repository
public interface StockRepository extends CrudRepository<StockEntity, Long>  {
    
}
