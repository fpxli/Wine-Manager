package io.github.fpxli.wine_manager.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import io.github.fpxli.wine_manager.domain.enums.TipoVinho;
import io.github.fpxli.wine_manager.domain.model.Vinho;

@Repository
public interface VinhoRepo extends JpaRepository<Vinho, UUID> {
    List<Vinho> findByTipo(TipoVinho tipoSugerido);

    @Query("SELECT v FROM Vinho v WHERE v.tipo IN " + "(SELECT h.tipoVinho FROM Harmonizacao h WHERE h.tipoComida = :comida)")
    List<Vinho> buscarPorHarmonizacao(@Param("comida") TipoComida comida);
}