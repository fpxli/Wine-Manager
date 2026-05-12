package io.github.fpxli.wine_manager.DTO;

import java.math.BigDecimal;
import java.util.UUID;

import io.github.fpxli.wine_manager.domain.enums.TipoSake;
import io.github.fpxli.wine_manager.domain.model.Sake;

public record SakeResponseDTO(
    UUID id,
    String nome,
    String produtor,
    Integer safra,
    String descricao,
    String nacionalidade,
    BigDecimal preco,
    TipoSake tipo,
    Integer polimento,
    Double smv,
    boolean junmai
) {

    public static SakeResponseDTO deEntity(Sake s) {
     return new SakeResponseDTO(
            s.getId(),
            s.getNome(),
            s.getProdutor(),
            s.getSafra(),
            s.getDescricao(),
            s.getNacionalidade(),
            s.getPreco(),
            s.getTipo(),
            s.getPolimento(),
            s.getSmv(),
            s.getJunmai()
        );
    }
}
