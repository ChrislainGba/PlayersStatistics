package com.latelier.playersstatistics.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latelier.playersstatistics.entities.Country;
import com.latelier.playersstatistics.entities.Player;
import com.latelier.playersstatistics.repositories.CountryRepository;
import com.latelier.playersstatistics.repositories.PlayerRepository;
import com.latelier.playersstatistics.services.CountryService;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	CountryRepository countryRepository;

	@Override
	public Country getCountryWithHighWinningRatio() {
		
		Map<String, Double> countryWinningRatios = new HashMap<String, Double>();
		
		List<Player> players = playerRepository.findAll();
		String country = null;
		
		// Calculate winning ratios for each country
	    for (Player player : players) {
	        country = player.getCountry().getCode();
	     // calculate the wins of the player
	        double wins = calculateWins(player); 
	        double totalMatches = player.getData().getLast().size();
	        double winningRatio = wins / totalMatches;

	        if (countryWinningRatios.containsKey(country)) {
	            // If country exists, update the winning ratio if it's higher
	            double currentRatio = countryWinningRatios.get(country);
	            if (winningRatio > currentRatio) {
	                countryWinningRatios.put(country, winningRatio);
	            }
	        } else {
	            countryWinningRatios.put(country, winningRatio);
	        }
	    }
		
		
		return countryRepository.findById(country).get();
	}
	
	public int calculateWins(Player player) {
	    int wins = 0;
	    List<Integer> lastResults = player.getData().getLast();

	    for (int result : lastResults) {
	        if (result == 1) {
	            wins++;
	        }
	    }

	    return wins;
	}

}
 