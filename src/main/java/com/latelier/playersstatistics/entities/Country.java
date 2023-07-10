package com.latelier.playersstatistics.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Country implements Serializable{
    @Id
    private String code;
    private String picture;
    
    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Player> players;
}
