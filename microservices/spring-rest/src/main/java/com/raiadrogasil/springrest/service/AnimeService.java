package com.raiadrogasil.springrest.service;

import com.raiadrogasil.springrest.domain.Anime;
import com.raiadrogasil.springrest.dto.AnimeRecordDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimeService {

    AnimeRecordDto createAnime(AnimeRecordDto dto);
    void delete(Long id);
    AnimeRecordDto findById(Long id);
    List<AnimeRecordDto> listAll();
    Anime replace (Anime anime);

}
