package io.github.fpxli.wine_manager.domain.model;

import java.util.UUID;

import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import io.github.fpxli.wine_manager.domain.enums.TipoSake;
import io.github.fpxli.wine_manager.domain.enums.TipoVinho;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "harmonizacoes")
@Getter @Setter
@NoArgsConstructor
public class Harmonizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoComida comida;

    @Enumerated(EnumType.STRING)
    private TipoVinho vinho;

    @Enumerated(EnumType.STRING)
    private TipoSake sake;

}
