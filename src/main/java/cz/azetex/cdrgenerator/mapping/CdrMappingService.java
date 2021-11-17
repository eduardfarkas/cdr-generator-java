package cz.azetex.cdrgenerator.mapping;

import cz.azetex.cdrgenerator.dto.CdrDto;
import cz.azetex.cdrgenerator.model.Cdr;
import org.springframework.stereotype.Service;

@Service
public class CdrMappingService {
    public CdrDto createCdrDto(Cdr cdr) {
        return CdrDto.of(cdr);
    }
}
