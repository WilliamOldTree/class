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
        var animeId = findById(id);
        repository.deleteById(animeId.getId());
    }

    @Override
    public List<AnimeRecordDto> listAll() {
        List <Anime> animes = new ArrayList<>();
        animes = ;
        return repository.findAll();
    }

    @Override
    public Anime replace(Anime anime) {
        Anime existingAnime = findById(anime.getId());
        existingAnime.setName(anime.getName());
        return existingAnime;
    }


}
