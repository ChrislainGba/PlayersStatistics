package com.latelier.playersstatistics.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.latelier.playersstatistics.entities.Country;
import com.latelier.playersstatistics.entities.Player;
import com.latelier.playersstatistics.entities.PlayerData;
import com.latelier.playersstatistics.repositories.CountryRepository;
import com.latelier.playersstatistics.repositories.PlayerDataRepository;
import com.latelier.playersstatistics.repositories.PlayerRepository;
import com.latelier.playersstatistics.services.LoadDataService;
import com.latelier.playersstatistics.wrapper.PlayerDataWrapper;

import jakarta.transaction.Transactional;
@Service
public class LoadDataServiceImpl implements LoadDataService{
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	PlayerDataRepository playerDataRepository;

	@Override
	@Transactional
	public void load() {
		
		try {
			Resource resource = new ClassPathResource("headtohead.json");
	        InputStream inputStream = resource.getInputStream();
	        ObjectMapper objectMapper = new ObjectMapper();
			List<Player> players = objectMapper.readValue(inputStream, new TypeReference<List<Player>>() {});
			for (Player player : players) {
                Country country = countryRepository.findById(player.getCountry().getCode())
                        .orElseGet(() -> countryRepository.save(player.getCountry()));
                player.setCountry(country);
                
                player.getData().setId(generatePlayerId());
                PlayerData playerData = playerDataRepository.save(player.getData());
                player.setData(playerData);
                //player.setId(null);
            }
            playerRepository.saveAll(players);
			 
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	Long generatePlayerId() {
	    long timestamp = System.currentTimeMillis();
	    long randomNumber = new Random().nextLong();
	    return timestamp + randomNumber;
	}

}
