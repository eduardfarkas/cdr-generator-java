package cz.azetex.cdrgenerator.configuration;

import cz.azetex.cdrgenerator.configuration.converters.StringToDataTypeEnumConverter;
import cz.azetex.cdrgenerator.configuration.converters.StringToOperatorTypeEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDataTypeEnumConverter());
        registry.addConverter(new StringToOperatorTypeEnumConverter());
    }
}
