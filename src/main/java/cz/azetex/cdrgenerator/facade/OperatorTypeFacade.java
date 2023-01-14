package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.services.DataTypeService;
import cz.azetex.cdrgenerator.services.OperatorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorTypeFacade {

    private final OperatorTypeService operatorTypeService;

    public ResponseDto findAllOperatorTypes() {
        ResponseDto responseDto = new ResponseDto();

        List<String> operatorTypeList = operatorTypeService.findAllOperatorTypes();

        operatorTypeList.stream()
            .forEach(responseDto.getData()::add);

        return responseDto;
    }
}
