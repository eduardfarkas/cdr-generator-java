package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.PaginationDto;
import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.dto.ResponseInformationDto;
import cz.azetex.cdrgenerator.error.CdrNotFoundException;
import cz.azetex.cdrgenerator.mapping.enumeration.CdrMapping;
import cz.azetex.cdrgenerator.model.Cdr;
import cz.azetex.cdrgenerator.services.CdrService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CdrFacade {

    private final CdrService cdrService;
    private final CdrMapping cdrMapping;

    public ResponseDto getCdrById(Long id) {
        Cdr cdr = cdrService.findById(id)
                .orElseThrow(() -> new CdrNotFoundException("Cdr with id '" + id + "' was not found"));

        ResponseDto responseDto = new ResponseDto();
        responseDto.getData().getCdrs().add(cdrMapping.toDto(cdr));

        return responseDto;
    }

    public ResponseDto getCdrs(String operatorTypeName, String dataTypeName, int page, int pageSize) {
        ResponseDto responseDto = new ResponseDto();

        PageRequest pageable = PageRequest.of(page, pageSize);

        Page<Cdr> result = cdrService.findCdrs(operatorTypeName, dataTypeName, pageable);
        result.stream()
                .map(cdrMapping::toDto)
                .forEach(responseDto.getData().getCdrs()::add);

        setPageInfo(responseDto, result);

        return responseDto;
    }

    public static void setPageInfo(ResponseDto responseDto, Page<?> pageResult) {
        PaginationDto paginationDto = new PaginationDto();
        paginationDto.setTotalRecords((int) pageResult.getTotalElements());
        paginationDto.setTotalPages(pageResult.getTotalPages());
        Pageable pageable = pageResult.getPageable();
        if (pageable.isPaged()) {
            paginationDto.setPage(pageable.getPageNumber());
            paginationDto.setPageSize(pageable.getPageSize());
        }

        ResponseInformationDto responseInformationDto = new ResponseInformationDto();
        responseInformationDto.setPagination(paginationDto);
        responseDto.setMeta(responseInformationDto);
    }
}