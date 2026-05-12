package io.github.fpxli.wine_manager.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.fpxli.wine_manager.DTO.SakeRequestDTO;
import io.github.fpxli.wine_manager.DTO.SakeResponseDTO;
import io.github.fpxli.wine_manager.Services.SakeService;
import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sakes")
@RequiredArgsConstructor
public class SakeController {
    private final SakeService sakeService;

    @PostMapping
    public ResponseEntity<SakeResponseDTO> salvar(@RequestBody @Valid SakeRequestDTO dto){
        var salvo = sakeService.salvarSake(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/sugestao")
    public ResponseEntity<List<SakeResponseDTO>> getSugestoes(@RequestParam TipoComida comida){
        return ResponseEntity.ok(sakeService.buscarSugestoesParaComida(comida));
    }

    @GetMapping("/{id}/comidas")
    public ResponseEntity<List<TipoComida>> getComidasParaSake(@PathVariable UUID id){
        return ResponseEntity.ok(sakeService.listarComidasParaSake(id));
    }
}