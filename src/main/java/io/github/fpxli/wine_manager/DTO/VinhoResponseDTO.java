package io.github.fpxli.wine_manager.DTO;

import java.math.BigDecimal;
import java.util.UUID;

import io.github.fpxli.wine_manager.domain.enums.TipoVinho;
import io.github.fpxli.wine_manager.domain.model.Vinho;

public record VinhoResponseDTO(
        UUID id,
        String nome,
        String vinicola,
        Integer safra,
        String nacionalidade, 
        String descricao,     
        BigDecimal preco,
        TipoVinho tipo,
        Integer corpo,
        Integer acidez,
        Integer tanino,
        Integer docura
) {
    public static VinhoResponseDTO deEntity(Vinho v) {
        return new VinhoResponseDTO(
                v.getId(), 
                v.getNome(), 
                v.getVinicola(), 
                v.getSafra(), 
                v.getNacionalidade(), 
                v.getDescricao(),      
                v.getPreco(), 
                v.getTipo(), 
                v.getCorpo(), 
                v.getAcidez(),
                v.getTanino(), 
                v.getDocura()
        );
    }
}