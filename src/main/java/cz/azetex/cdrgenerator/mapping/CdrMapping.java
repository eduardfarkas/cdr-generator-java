package cz.azetex.cdrgenerator.mapping;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import cz.azetex.cdrgenerator.dto.CdrDto;
import cz.azetex.cdrgenerator.model.Cdr;
import org.springframework.stereotype.Service;

@Service
public class CdrMapping {
    public CdrDto createCdrDto(Cdr cdr) {
        return CdrDto.of(cdr);
    }

}
