package com.latelier.playersstatistics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latelier.playersstatistics.entities.Country;
import com.latelier.playersstatistics.services.CountryService;
import com.latelier.playersstatistics.services.PlayerService;


@RestController
@RequestMapping("/statistic")
public class StatisticsController {
	@Autowired
	PlayerService playerService;
	@Autowired
	CountryService countryService;
	
	
	@GetMapping("/imc")
    public ResponseEntity<Double> getAverageIMC() throws Exception {
        try {
            Double averageIMC = playerService.getAverageIMC();
            return ResponseEntity.ok(averageIMC);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
	@GetMapping("/median")
    public ResponseEntity<Integer> getMedianHeight() throws Exception {
        try {
            Integer medianHeight = playerService.getMedianHeight();
            return ResponseEntity.ok(medianHeight);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
	
	 @GetMapping("/ratio")
    public ResponseEntity<Country> getCountryWithHighestWinningRatio() throws Exception{
        try {
            Country country = countryService.getCountryWithHighWinningRatio();
            return ResponseEntity.ok(country);
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
