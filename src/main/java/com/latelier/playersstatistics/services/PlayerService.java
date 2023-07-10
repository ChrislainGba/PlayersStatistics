package com.latelier.playersstatistics.services;

import java.util.List;

import com.latelier.playersstatistics.entities.Player;

public interface PlayerService {
	public List<Player> findAll();
	public Player findById(Long id);
	public Double getAverageIMC();
	public Integer getMedianHeight();

}
