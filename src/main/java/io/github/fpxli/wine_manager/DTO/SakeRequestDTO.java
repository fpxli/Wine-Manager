package io.github.fpxli.wine_manager.DTO;

import java.math.BigDecimal;

import io.github.fpxli.wine_manager.domain.enums.TipoSake;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SakeRequestDTO(
    @NotBlank(message = "O nome é obrigatório")
    String nome,

    @NotBlank(message = "O produtor é obrigatório")
    String produtor,

    @NotNull(message = "A safra é obrigatória")
    Integer safra,

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 2000, message = "A descrição não pode exceder 2000 caracteres")
    String descricao,

    @NotBlank(message = "A nacionalidade é obrigatória")
    String nacionalidade,

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço do sake deve ser maior que zero")
    BigDecimal preco,

    @NotNull(message = "O tipo do Sake é obrigatório")
    TipoSake tipo,

    @NotNull(message = "O polimento é obrigatório")
    @Min(1) @Max(100)
    Integer polimento,

    @NotNull(message = "O SMV é obrigatório")
    @DecimalMin("-15.0") @DecimalMax("15.0")
    Double smv,

    @NotNull(message = "Deve se confirmar se é junmai")
    Boolean junmai
) {}