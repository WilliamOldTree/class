package com.raiadrogasil.springrest.controller;

import com.raiadrogasil.springrest.domain.Anime;
import com.raiadrogasil.springrest.dto.AnimeRecordDto;
import com.raiadrogasil.springrest.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimeController {


    private final AnimeService animeService;

    @PostMapping
    public ResponseEntity<AnimeRecordDto> save(@RequestBody AnimeRecordDto dto){
        return new ResponseEntity<>(animeService.createAnime(dto), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity <AnimeRecordDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<AnimeRecordDto>> list(){
        return ResponseEntity.ok(animeService.listAll());
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Anime anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
