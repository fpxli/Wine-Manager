package io.github.fpxli.wine_manager.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.fpxli.wine_manager.domain.model.Harmonizacao;
import io.github.fpxli.wine_manager.repository.HarmonizacaoRepo;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/harmonizacoes")
@RequiredArgsConstructor
public class HarmonizacaoController {

    private final HarmonizacaoRepo harmonizacaoRepo;

    @PostMapping
    public ResponseEntity<Harmonizacao> criarRegra(@RequestBody Harmonizacao regra) {
        Harmonizacao salva = harmonizacaoRepo.save(regra);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public ResponseEntity<List<Harmonizacao>> listarRegras() {
        return ResponseEntity.ok(harmonizacaoRepo.findAll());
    }
}