package br.com.casadocodigo.service;

import br.com.casadocodigo.domain.Livro;
import br.com.casadocodigo.mapper.LivroTransformMapper;
import br.com.casadocodigo.repository.LivroRepository;
import br.com.commons.dto.LivroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    LivroTransformMapper mapper;

    public List<LivroDTO> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return mapper.toDTO(livros);
    }

    @Transactional
    public LivroDTO criarLivro(LivroDTO dto) {
        Livro livro = mapper.toEntity(dto);
        return mapper.toDTO(livroRepository.save(livro));
    }
}

