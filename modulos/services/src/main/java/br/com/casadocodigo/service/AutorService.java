package br.com.casadocodigo.service;

import br.com.casadocodigo.domain.Autor;
import br.com.casadocodigo.mapper.AutorTransformMapper;
import br.com.casadocodigo.repository.AutorRepository;
import br.com.commons.dto.AutorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    AutorTransformMapper mapper;

    @Transactional
    public AutorDTO criarAutor(AutorDTO dto) {
        Autor autor = mapper.toEntity(dto);
        return mapper.toDTO(autorRepository.save(autor));

    }

    @Transactional
    public AutorDTO buscarAutorPorId(UUID id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.isPresent() ? mapper.toDTO(autor.get()) : new AutorDTO();
    }

    public AutorDTO buscarAutorPorNome(String nome) {
        Optional<Autor> autor = autorRepository.findByName(nome);
        return autor.isPresent() ? mapper.toDTO(autor.get()) : new AutorDTO();
    }
}
