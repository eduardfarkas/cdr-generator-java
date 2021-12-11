package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.entities.CdrDetailDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.Cdr;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CdrDetailMapping extends BaseMapping<Cdr, CdrDetailDto> {

    CdrDetailDto toDto(Cdr cdr);

}
