package io.github.fpxli.wine_manager.DTO;

import java.math.BigDecimal;

import io.github.fpxli.wine_manager.domain.enums.TipoVinho;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record VinhoRequestDTO(
        @NotBlank(message = "O nome é obrigatório") 
        String nome,

        @NotBlank(message = "A vinícola é obrigatória") 
        String vinicola,

        @NotNull(message = "A safra é obrigatória") 
        Integer safra,

        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 2000, message = "A descrição não pode exceder 2000 caracteres")
        String descricao,

        @NotBlank
        String nacionalidade,

        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @NotNull(message = "O tipo do vinho é obrigatório") 
        TipoVinho tipo,

        @NotNull @Min(1) @Max(5) Integer corpo,
        @NotNull @Min(1) @Max(5) Integer acidez,
        @NotNull @Min(1) @Max(5) Integer tanino,
        @NotNull @Min(1) @Max(5) Integer docura
) {}
