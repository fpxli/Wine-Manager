package io.github.fpxli.wine_manager.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import io.github.fpxli.wine_manager.domain.enums.TipoSake;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sakes")
@Getter @Setter
public class Sake {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private String produtor;

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

    @Enumerated(EnumType.STRING)
    private TipoSake tipo;

    @NotNull
    @Min(value = 1, message = "O polimento mínimo é 1%")
    @Max(value = 100, message = "O polimento máximo é 100%")
    private Integer polimento;

    @NotNull
    @DecimalMin(value = "-15.0", message = "O SMV muito baixo indica doçura extrema fora dos padrões")
    @DecimalMax(value = "15.0", message = "O SMV muito alto indica secura extrema fora dos padrões")
    private Double smv;

    @NotNull
    private Boolean junmai;
}