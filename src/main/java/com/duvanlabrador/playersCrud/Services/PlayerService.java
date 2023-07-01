package com.duvanlabrador.playersCrud.Services;

import com.duvanlabrador.playersCrud.Entity.PlayerEntity;
import com.duvanlabrador.playersCrud.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<PlayerEntity> getAllPlayers(){
        return this.playerRepository.findAll();
    }

    public void savePLayer(PlayerEntity player){
        this.playerRepository.save(player);
    }

    public PlayerEntity getPlayerForId(Long id){
        return this.playerRepository.findById(id).get();
    }

    public void deletePlayer(Long id){
        this.playerRepository.deleteById(id);
    }




}
