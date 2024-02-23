package com.liveasy.app.api.controller;

import com.liveasy.app.api.model.Logistics;
import com.liveasy.app.api.service.LogisticsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class LogisticsControllerTest {

    private static final String SHIPPER_ID = "MOCK_123";
    private static final Long LOAD_ID = 1L;

    @InjectMocks
    private LogisticsController logisticsController;

    @Mock
    private LogisticsService logisticsService;

    @Test
    void testAddLoad() {
        Logistics logistics = new Logistics();
        doNothing().when(logisticsService).addLoad(any(Logistics.class));

        ResponseEntity<String> response = logisticsController.addLoad(logistics);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Load details added successfully", response.getBody());
    }

    @Test
    void testGetLoadsByShipperId() {
        List<Logistics> expectedLogisticsList = Arrays.asList(new Logistics(), new Logistics());
        when(logisticsService.getLoadsByShipperId(SHIPPER_ID)).thenReturn(expectedLogisticsList); // Mock the service

        ResponseEntity<Object> response = logisticsController.getLoadsByShipperId(SHIPPER_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedLogisticsList, response.getBody());
    }

    @Test
    void testGetLoadById() {
        Logistics expectedLogistics = new Logistics();
        when(logisticsService.getLoadById(LOAD_ID)).thenReturn(Optional.of(expectedLogistics)); // Mock the service

        ResponseEntity<Object> response = logisticsController.getLoadById(LOAD_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedLogistics, response.getBody());
    }

    @Test
    void testUpdateLoad() {
        Long loadId = 1L;
        Logistics updatedLogistics = new Logistics();
        when(logisticsService.getLoadById(any())).thenReturn(Optional.of(updatedLogistics));
        doNothing().when(logisticsService).updateLoad(loadId, updatedLogistics); // Mock the service

        ResponseEntity<String> response = logisticsController.updateLoad(loadId, updatedLogistics);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Load details updated successfully", response.getBody());
    }

    @Test
    void testDeleteLoad() {
        Logistics updatedLogistics = new Logistics();
        when(logisticsService.getLoadById(any())).thenReturn(Optional.of(updatedLogistics));
        doNothing().when(logisticsService).deleteLoad(LOAD_ID);

        ResponseEntity<String> response = logisticsController.deleteLoad(LOAD_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Load deleted successfully", response.getBody());
    }
}
