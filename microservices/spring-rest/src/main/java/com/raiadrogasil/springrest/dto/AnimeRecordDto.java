package com.raiadrogasil.springrest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record AnimeRecordDto(
        Long id,
        String nome) {
}
