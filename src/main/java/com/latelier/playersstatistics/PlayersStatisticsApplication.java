package com.latelier.playersstatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.latelier.playersstatistics.services.LoadDataService;

@SpringBootApplication
public class PlayersStatisticsApplication implements CommandLineRunner{
	@Autowired
	private LoadDataService loadDataService;

	public static void main(String[] args) {
		SpringApplication.run(PlayersStatisticsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loadDataService.load();
		
	}

}
