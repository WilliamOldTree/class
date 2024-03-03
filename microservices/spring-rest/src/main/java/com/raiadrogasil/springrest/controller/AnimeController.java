package com.raiadrogasil.springrest.controller;

import com.raiadrogasil.springrest.domain.Anime;
import com.raiadrogasil.springrest.dto.AnimeRecordDto;
import com.raiadrogasil.springrest.mapper.AnimeMapper;
import com.raiadrogasil.springrest.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/anime")
public class AnimeController {


    private final AnimeService animeService;

    @PostMapping
    public ResponseEntity<AnimeRecordDto> save(@RequestBody AnimeRecordDto dto){
        AnimeRecordDto savedUser = animeService.createAnime(dto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
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

    @GetMapping
    public ResponseEntity<List<AnimeRecordDto>> list(){
        List<AnimeRecordDto> animes = animeService.listAll();
        return new ResponseEntity<>(animes, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<AnimeRecordDto> replace(@RequestBody AnimeRecordDto dto,
                                                  @PathVariable Long id ){
        var anime = AnimeMapper.toAnime(dto);
        anime.setId(id);        AnimeRecordDto recordDto = animeService.replace(dto);
        return new ResponseEntity<>(recordDto, HttpStatus.NO_CONTENT);
    }

}
