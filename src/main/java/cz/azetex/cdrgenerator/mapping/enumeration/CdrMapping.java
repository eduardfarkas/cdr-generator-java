package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.entities.CdrDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.Cdr;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CdrMapping extends BaseMapping<Cdr, CdrDto> {

    @Mapping(target = "extensionName",      source = "cdr.extension.name")
    @Mapping(target = "groupName",          source = "cdr.group.name")
    CdrDto toDto(Cdr cdr);

}
