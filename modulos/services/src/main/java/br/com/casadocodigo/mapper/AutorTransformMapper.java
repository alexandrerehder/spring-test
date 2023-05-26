package br.com.casadocodigo.mapper;

import br.com.casadocodigo.domain.Autor;
import br.com.commons.dto.AutorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AutorTransformMapper {

    public abstract AutorDTO toDTO(Autor autor);

    @Mapping(target = "id", ignore = true)
    public abstract Autor toEntity(AutorDTO dto);
}
