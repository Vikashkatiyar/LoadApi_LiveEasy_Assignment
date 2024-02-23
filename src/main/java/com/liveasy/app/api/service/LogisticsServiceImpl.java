package com.liveasy.app.api.service;

import com.liveasy.app.api.model.Logistics;
import com.liveasy.app.api.repository.LogisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Vikash Katiyar
 * 
 */

@Service
public class LogisticsServiceImpl implements LogisticsService{
    private final LogisticsRepository logisticsRepository;

    @Autowired
    public LogisticsServiceImpl(LogisticsRepository logisticsRepository) {
        this.logisticsRepository = logisticsRepository;
    }

    //Adds the load into the database
    @Override
    public void addLoad(Logistics logistics) {
        logisticsRepository.save(logistics);
    }

    //Gets all the Logistics with the shipperId and returns the list of Logistics
    @Override
    public List<Logistics> getLoadsByShipperId(String shipperId) {
        return logisticsRepository.findByShipperId(shipperId);
    }

    // Returns all the Logistics
    @Override
    public List<Logistics> getAllLoads() {
        return logisticsRepository.findAll();
    }

    // Returns the Logistic for the given loadId if not present it will return Optional<null>
    @Override
    public Optional<Logistics> getLoadById(Long loadId) {
        return logisticsRepository.findById(loadId);
    }

    // Used for updating the Load with the given Logistics
    @Override
    public void updateLoad(Long loadId, Logistics updatedLogistics) {
        if (logisticsRepository.existsById(loadId)) {
            updatedLogistics.setLoadId(loadId);
            logisticsRepository.save(updatedLogistics);
        }
    }

    // Used for deleting the given loadId
    @Override
    public void deleteLoad(Long loadId) {
        logisticsRepository.deleteById(loadId);
    }
}
