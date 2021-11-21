package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.CdrDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.Cdr;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CdrMapping extends BaseMapping<Cdr, CdrDto> {

    @Mapping(target = "dataTypeName",       source = "cdr.dataType.name")
    @Mapping(target = "extensionName",      source = "cdr.extension.name")
    @Mapping(target = "groupName",          source = "cdr.group.name")
    @Mapping(target = "operatorTypeName",   source = "cdr.operatorType.name")
    CdrDto toDto(Cdr cdr);

}
