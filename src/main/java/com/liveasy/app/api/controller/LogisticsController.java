package com.liveasy.app.api.controller;

import com.liveasy.app.api.model.Logistics;
import com.liveasy.app.api.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Implemented four types of call : post, get, put, delete



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/load")
public class LogisticsController {
    private final LogisticsService logisticsService;

    @Autowired
    public LogisticsController(LogisticsService logisticsService) {
        this.logisticsService = logisticsService;
    }

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Logistics logistics) {
        try {
            logisticsService.addLoad(logistics);
            return ResponseEntity.ok("Load details added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding logistic details: " + e.getMessage());
        }
    }

    /*
     * In this call it will give all the load with the given shipperId when the required param is provided.
     * If the param is not provided(i.e. null) then it provides all the loads.
     */
    @GetMapping
    public ResponseEntity<Object> getLoadsByShipperId(@RequestParam(name = "shipperId", required = false) String shipperId) {
        List<Logistics> logistics;
        if (shipperId != null) {
            logistics = logisticsService.getLoadsByShipperId(shipperId);
            if (logistics.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("There are no logistics with the given shipperId "+ shipperId);
            }
        } else {
            logistics = logisticsService.getAllLoads();
        }
        return ResponseEntity.ok(logistics);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Object> getLoadById(@PathVariable Long loadId) {
        Optional<Logistics> optionalLoad = logisticsService.getLoadById(loadId);
        return optionalLoad.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Load with ID " + loadId + " not found. Please enter a valid input"));
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable Long loadId, @RequestBody Logistics updatedLogistics) {
        try {
            Optional<Logistics> optionalLoad = logisticsService.getLoadById(loadId);
            if (optionalLoad.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logistics Not Found for this ID : " + loadId);
            }
            logisticsService.updateLoad(loadId, updatedLogistics);
            return ResponseEntity.ok("Load details updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logistics Not Found for this ID : " + loadId);
        }
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        try {
            Optional<Logistics> optionalLoad = logisticsService.getLoadById(loadId);
            if (optionalLoad.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logistics Not Found for this ID : " + loadId);
            }
            logisticsService.deleteLoad(loadId);
            return ResponseEntity.ok("Load deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logistics Not Found for this ID : " + loadId);
        }
    }
}


