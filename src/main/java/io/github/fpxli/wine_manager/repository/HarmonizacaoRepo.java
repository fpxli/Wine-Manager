package io.github.fpxli.wine_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import io.github.fpxli.wine_manager.domain.enums.TipoSake;
import io.github.fpxli.wine_manager.domain.enums.TipoVinho;
import io.github.fpxli.wine_manager.domain.model.Harmonizacao;

@Repository
public interface HarmonizacaoRepo extends JpaRepository<Harmonizacao, Long> {

    // 1. Busca todas as regras para uma comida específica 
    List<Harmonizacao> findByComida(TipoComida comida);

    // 2. Busca todas as regras para um tipo de vinho 
    List<Harmonizacao> findByTipoVinho(TipoVinho tipoVinho);

    //3. Busca todas as egras para um tipo de sake
    List<Harmonizacao> findByTipoSake(TipoSake tipoSake);
}