package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.CdrResponseDto;
import cz.azetex.cdrgenerator.dto.ResponseInformationDto;
import cz.azetex.cdrgenerator.mapping.CdrMapping;
import cz.azetex.cdrgenerator.model.Cdr;
import cz.azetex.cdrgenerator.services.CdrServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CdrFacade {

    private final CdrServiceImpl cdrService;
    private final CdrMapping cdrMapping;

    public CdrResponseDto getCdrById(Long id) {
        Optional<Cdr> cdr = cdrService.findById(id);
        CdrResponseDto cdrResponseDto = new CdrResponseDto();

        if(cdr.isPresent()) {
            cdrResponseDto.getData().add(cdrMapping.createCdrDto(cdr.get()));
        }
        return cdrResponseDto;
    }

    public CdrResponseDto getCdrs(String operatorTypeName, String dataTypeName, int page, int pageSize) {
        CdrResponseDto responseDto = new CdrResponseDto();

        PageRequest pageable = PageRequest.of(page, pageSize);

        responseDto.setMeta(new ResponseInformationDto("halo"));

        cdrService.findCdrs(operatorTypeName, dataTypeName, pageable).stream()
                .map(cdrMapping::createCdrDto)
                .forEach(responseDto.getData()::add);

        return responseDto;
    }

}