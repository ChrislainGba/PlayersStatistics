package com.latelier.playersstatistics.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Player implements Serializable{
	@Id
    private Long id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    private String picture;
    
    @ManyToOne
    private Country country;
    
    @OneToOne
    private PlayerData data;
}
