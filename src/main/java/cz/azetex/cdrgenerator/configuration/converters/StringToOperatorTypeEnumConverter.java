package cz.azetex.cdrgenerator.configuration.converters;

import cz.azetex.cdrgenerator.model.enums.OperatorType;
import org.springframework.core.convert.converter.Converter;

public class StringToOperatorTypeEnumConverter implements Converter<String, OperatorType> {
    @Override
    public OperatorType convert(String source) {
        return OperatorType.valueOf(source.toUpperCase());
    }
}
