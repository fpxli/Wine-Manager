package io.github.fpxli.wine_manager.DTO;

import io.github.fpxli.wine_manager.domain.enums.TipoComida;

import java.util.List;

public record HarmonizacaoDTO(
        TipoComida comida,
        List<VinhoResponseDTO> vinhosSugeridos,
        List<SakeResponseDTO> sakesSugeridos
) {}