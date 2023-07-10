package com.latelier.playersstatistics.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.latelier.playersstatistics.entities.Player;
import com.latelier.playersstatistics.repositories.PlayerRepository;
import com.latelier.playersstatistics.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	@Autowired
	PlayerRepository playerRepository;

	@Override
	public List<Player> findAll() {	
		return playerRepository.findAll(Sort.by(Sort.Direction.DESC,"data.rank"));
	}

	@Override
	public Player findById(Long id) {
		return playerRepository.findById(id).get();
	}

	@Override
	public Double getAverageIMC() {
		List<Player> players = playerRepository.findAll();
		
		double totalIMC = 0.0;
        for (Player player : players) {
            double weightInKg = player.getData().getWeight() / 1000.0;
            double heightInMeters = player.getData().getHeight() / 100.0;

            double imc = weightInKg / (heightInMeters * heightInMeters);

            totalIMC += imc;
        }

        // Calculate average
        double averageIMC = totalIMC / players.size();

        return averageIMC;
	}

	@Override
	public Integer getMedianHeight() {
		List<Player> players = playerRepository.findAll();
		List<Integer> heights = new ArrayList<Integer>();
	    for (Player player : players) {
	        heights.add(player.getData().getHeight());
	    }
	    
	    Collections.sort(heights);
	    int size = heights.size();

	    if (size % 2 == 1) {
	        return heights.get((size+1) / 2);
	    } else {
	        int midIndex1 = size / 2;
	        int midIndex2 = size / 2 + 1;
	        return (heights.get(midIndex1) + heights.get(midIndex2)) / 2;
	    }
	}

}
