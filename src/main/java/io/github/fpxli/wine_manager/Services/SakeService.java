package io.github.fpxli.wine_manager.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.fpxli.wine_manager.DTO.SakeRequestDTO;
import io.github.fpxli.wine_manager.DTO.SakeResponseDTO;
import io.github.fpxli.wine_manager.domain.enums.TipoComida;
import io.github.fpxli.wine_manager.domain.model.Harmonizacao;
import io.github.fpxli.wine_manager.domain.model.Sake;
import io.github.fpxli.wine_manager.repository.HarmonizacaoRepo;
import io.github.fpxli.wine_manager.repository.SakeRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SakeService {

    private final SakeRepo sakerepository;
    private final HarmonizacaoRepo harmonizacaoRepo;
    
    @Transactional
    public SakeResponseDTO salvarSake(SakeRequestDTO dto){
        Sake sake = new Sake();
        sake.setNome(dto.nome());
        sake.setProdutor(dto.produtor());
        sake.setSafra(dto.safra());
        sake.setDescricao(dto.descricao());
        sake.setNacionalidade(dto.nacionalidade());
        sake.setPreco(dto.preco());
        sake.setTipo(dto.tipo());
        sake.setPolimento(dto.polimento());
        sake.setSmv(dto.smv());
        sake.setJunmai(dto.junmai());

        Sake salvo = sakerepository.save(sake);
        return SakeResponseDTO.deEntity(salvo);
    }

    public List<SakeResponseDTO> buscarSugestoesParaComida(TipoComida comida){
        //O Banco de Dados decide quais vinhos retornam (harmonização)
        return sakerepository.buscarPorHarmonizacao(comida)
                .stream()
                .map(SakeResponseDTO::deEntity)
                .toList();
    }

    //A harmonização é realizada com base no Sake escolhido
    public List<TipoComida> listarComidasParaSake(UUID sakeId){
        //1. Busca o sake específico
        Sake sake = sakerepository.findById(sakeId)
            .orElseThrow(() -> new RuntimeException("Sake não encontrado"));

        //2. Busca na tabela de harmonização todas as comidas que aceitam o tipo deste sake
        return harmonizacaoRepo.findByTipoSake(sake.getTipo())
                .stream()
                .map(Harmonizacao::getComida)
                .toList();
    }

    public List<SakeResponseDTO> listarTodos() {
        return sakerepository.findAll()
                .stream()
                .map(SakeResponseDTO::deEntity)
                .toList();
    }
}
