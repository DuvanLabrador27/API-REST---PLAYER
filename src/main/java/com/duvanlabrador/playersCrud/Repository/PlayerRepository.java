package com.duvanlabrador.playersCrud.Repository;

import com.duvanlabrador.playersCrud.Entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
