package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.entities.DataTypeDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.DataType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTypeMapping extends BaseMapping<DataType, DataTypeDto> {

    DataTypeDto toDto(DataType dataType);
}
