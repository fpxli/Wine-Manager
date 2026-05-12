package io.github.fpxli.wine_manager.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import io.github.fpxli.wine_manager.domain.enums.TipoSake;
import io.github.fpxli.wine_manager.domain.model.Sake;



@Repository
public interface SakeRepo extends JpaRepository<Sake, UUID> {
        List<Sake> findByTipo(TipoSake tipoSugerido);

    @Query("SELECT s FROM Sake s WHERE s.tipo IN " + "(SELECT h.tipoSake FROM Harmonizacao h WHERE h.tipoComida = :comida)")
    List<Sake> buscarPorHarmonizacao(@Param("comida") TipoComida comida);
}