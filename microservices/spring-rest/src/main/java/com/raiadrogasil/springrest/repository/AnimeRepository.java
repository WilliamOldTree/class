package com.raiadrogasil.springrest.repository;

import com.raiadrogasil.springrest.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository <Anime, Long> {
   
}
