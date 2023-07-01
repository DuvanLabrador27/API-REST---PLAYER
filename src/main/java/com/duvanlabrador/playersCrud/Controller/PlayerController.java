package com.duvanlabrador.playersCrud.Controller;


import com.duvanlabrador.playersCrud.Entity.PlayerEntity;
import com.duvanlabrador.playersCrud.Services.PlayerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/player")
    public List<PlayerEntity> listPlayers(){
        return playerService.getAllPlayers();
    }
    @GetMapping("/player/{id}")
    public ResponseEntity<PlayerEntity> listPlayersForId(@PathVariable Long id){

        try{
        PlayerEntity player = playerService.getPlayerForId(id);
        return new ResponseEntity<PlayerEntity>(player, HttpStatus.ACCEPTED);
        }catch(Exception e){

            return new ResponseEntity<PlayerEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/player")
    public void addPlayer(@RequestBody PlayerEntity player){
        playerService.savePLayer(player);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerEntity> updatePlayer(@RequestBody PlayerEntity player, @PathVariable Long id){
        try{
            PlayerEntity nowPlayer = playerService.getPlayerForId(id);
            nowPlayer.setDate(player.getDate());
            nowPlayer.setName(player.getName());
            nowPlayer.setNumberShirt(player.getNumberShirt());
            nowPlayer.setPosition(player.getPosition());

            this.playerService.savePLayer(nowPlayer);
            return new ResponseEntity<PlayerEntity>(HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity<PlayerEntity>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/player/{id}")
    public ResponseEntity<PlayerEntity> deletePlayer(@PathVariable Long id){
        try{
            this.playerService.deletePlayer(id);
            return new ResponseEntity<PlayerEntity>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return  new ResponseEntity<PlayerEntity>(HttpStatus.CONFLICT);
        }
    }

}
