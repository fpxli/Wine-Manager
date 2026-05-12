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

import io.github.fpxli.wine_manager.DTO.VinhoRequestDTO;
import io.github.fpxli.wine_manager.DTO.VinhoResponseDTO;
import io.github.fpxli.wine_manager.Services.VinhoService;
import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/vinhos")
@RequiredArgsConstructor
public class VinhoController {
    private final VinhoService vinhoService;
    
    @PostMapping
    public ResponseEntity<VinhoResponseDTO> salvar(@RequestBody @Valid VinhoRequestDTO dto){
        var salvo = vinhoService.salvarVinho(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("/sugestao")
    public ResponseEntity<List<VinhoResponseDTO>> getSugestoes(@RequestParam TipoComida comida){
        return ResponseEntity.ok(vinhoService.buscarSugestoesParaComida(comida));
    }

    @GetMapping("/{id}/comidas")
    public ResponseEntity<List<TipoComida>> getComidasParaVinho(@PathVariable UUID id){
        return ResponseEntity.ok(vinhoService.listarComidasParaVinho(id));
    }
    
}
