package cz.azetex.cdrgenerator.configuration.converters;

import cz.azetex.cdrgenerator.model.enums.DataType;
import org.springframework.core.convert.converter.Converter;

public class StringToDataTypeEnumConverter implements Converter<String, DataType> {
    @Override
    public DataType convert(String source) {
        return DataType.valueOf(source.toUpperCase());
    }
}
