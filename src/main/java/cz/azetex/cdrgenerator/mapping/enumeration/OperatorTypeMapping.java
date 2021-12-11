package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.entities.OperatorTypeDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.OperatorType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperatorTypeMapping extends BaseMapping<OperatorType, OperatorTypeDto> {

    OperatorTypeDto toDto(OperatorType operatorType);

}
