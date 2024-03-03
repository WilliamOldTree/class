package com.raiadrogasil.springrest.service.implement;

import com.raiadrogasil.springrest.domain.Anime;
import com.raiadrogasil.springrest.dto.AnimeRecordDto;
import com.raiadrogasil.springrest.mapper.AnimeMapper;
import com.raiadrogasil.springrest.repository.AnimeRepository;
import com.raiadrogasil.springrest.service.AnimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
@AllArgsConstructor
public class AnimeServiceImplements implements AnimeService {

    private final AnimeRepository repository;

    @Override
    public AnimeRecordDto createAnime(AnimeRecordDto dto) {
        var anime = AnimeMapper.toAnime(dto);
        var animeSaved = repository.save(anime);
        var animeSavedDto = AnimeMapper.toAnimeRecordDto(animeSaved);
        return  animeSavedDto;
    }

    @Override
    public AnimeRecordDto findById(Long id) {
        Optional<Anime> optionalAnime = repository.findById(id);
        var anime = optionalAnime.get();
        return  AnimeMapper.toAnimeRecordDto(anime);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AnimeRecordDto> listAll() {
        List <Anime> animes = repository.findAll();
        return animes.stream().map(AnimeMapper::toAnimeRecordDto )
                .collect(Collectors.toList());
    }

    @Override
    public AnimeRecordDto replace(AnimeRecordDto dto) {
        Anime existingAnime = repository.findById(dto.id()).get();
        existingAnime.setNome(dto.nome());
        Anime updateAnime = repository.save(existingAnime);
        return AnimeMapper.toAnimeRecordDto(updateAnime);
    }


}
