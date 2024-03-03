package com.raiadrogasil.springrest.mapper;

import com.raiadrogasil.springrest.domain.Anime;
import com.raiadrogasil.springrest.dto.AnimeRecordDto;

public class AnimeMapper {

    public static AnimeRecordDto toAnimeRecordDto (Anime anime){
        return new AnimeRecordDto(
                anime.getId(),
                anime.getNome()

        );
    }

    public static Anime toAnime (AnimeRecordDto dto){
        return new Anime(
                dto.id(),
                dto.nome()
        );
    }
}
