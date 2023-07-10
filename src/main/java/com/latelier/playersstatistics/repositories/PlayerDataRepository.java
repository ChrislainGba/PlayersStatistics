package com.latelier.playersstatistics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.latelier.playersstatistics.entities.PlayerData;

@Repository
public interface PlayerDataRepository extends JpaRepository<PlayerData, Long>{

}
