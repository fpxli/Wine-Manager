package io.github.fpxli.wine_manager.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import io.github.fpxli.wine_manager.domain.enums.TipoVinho;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vinhos")
@Getter @Setter

public class Vinho {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private String vinicola;

    @NotNull
    private Integer safra;

    @NotBlank(message = "A descrição é obrigatória para ajudar na harmonização")
    @Column(columnDefinition = "TEXT") 
    @Size(max = 2000, message = "A descrição não pode exceder 2000 caracteres") 
    private String descricao;

    @NotBlank
    private String nacionalidade;

    @NotNull
    private BigDecimal preco;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoVinho tipo;

    @NotNull
    @Min(1) @Max(5)
    private Integer corpo;

    @NotNull
    @Min(1) @Max(5)
    private Integer acidez;

    @NotNull
    @Min(1) @Max(5)
    private Integer tanino;

    @NotNull
    @Min(1) @Max(5)
    private Integer docura;
}


