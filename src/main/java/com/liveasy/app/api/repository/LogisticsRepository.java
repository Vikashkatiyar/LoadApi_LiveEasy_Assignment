package com.liveasy.app.api.repository;

import com.liveasy.app.api.model.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @author Vikash Katiyar
 * 
 */

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {
    /**
     * Retrieves a list of logistics entries based on the specified shipper's ID.
     */
    List<Logistics> findByShipperId(String shipperId);
}
