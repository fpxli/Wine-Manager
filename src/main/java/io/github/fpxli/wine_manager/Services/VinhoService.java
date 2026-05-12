package io.github.fpxli.wine_manager.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.fpxli.wine_manager.DTO.VinhoRequestDTO;
import io.github.fpxli.wine_manager.DTO.VinhoResponseDTO;
import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import io.github.fpxli.wine_manager.domain.model.Harmonizacao;
import io.github.fpxli.wine_manager.domain.model.Vinho;
import io.github.fpxli.wine_manager.repository.HarmonizacaoRepo;
import io.github.fpxli.wine_manager.repository.VinhoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VinhoService {

    private final VinhoRepo vinhoRepository;
    private final HarmonizacaoRepo harmonizacaoRepo; 

    @Transactional
    public VinhoResponseDTO salvarVinho(VinhoRequestDTO dto) {
        Vinho vinho = new Vinho();
        vinho.setNome(dto.nome());
        vinho.setVinicola(dto.vinicola());
        vinho.setSafra(dto.safra());
        vinho.setNacionalidade(dto.nacionalidade()); 
        vinho.setDescricao(dto.descricao());
        vinho.setPreco(dto.preco());
        vinho.setTipo(dto.tipo());
        vinho.setCorpo(dto.corpo());
        vinho.setAcidez(dto.acidez());
        vinho.setTanino(dto.tanino());
        vinho.setDocura(dto.docura());

        Vinho salvo = vinhoRepository.save(vinho);
        return VinhoResponseDTO.deEntity(salvo);
    }

    public List<VinhoResponseDTO> buscarSugestoesParaComida(TipoComida comida) {
        // O Banco de Dados decide quais vinhos retornam (harmonização)
        return vinhoRepository.buscarPorHarmonizacao(comida)
                .stream()
                .map(VinhoResponseDTO::deEntity)
                .toList();
    }

    // A harmonização é realizada com base no vinho escolhido
    public List<TipoComida> listarComidasParaVinho(UUID vinhoId) {
        // 1. Busca o vinho específico
        Vinho vinho = vinhoRepository.findById(vinhoId)
                .orElseThrow(() -> new RuntimeException("Vinho não encontrado"));

        // 2. Busca na tabela de harmonização todas as comidas que aceitam o tipo deste vinho
        return harmonizacaoRepo.findByTipoVinho(vinho.getTipo())
                .stream()
                .map(Harmonizacao::getComida)
                .toList();
    }

    public List<VinhoResponseDTO> listarTodos() {
        return vinhoRepository.findAll()
                .stream()
                .map(VinhoResponseDTO::deEntity)
                .toList();
    }
}