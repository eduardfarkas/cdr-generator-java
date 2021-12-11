package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.entities.ExtensionDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.Extension;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExtensionMapping extends BaseMapping<Extension, ExtensionDto> {

    ExtensionDto toDto(Extension extension);

}
