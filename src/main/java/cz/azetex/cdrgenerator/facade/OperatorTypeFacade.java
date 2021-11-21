package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.OperatorTypeAlreadyExistsException;
import cz.azetex.cdrgenerator.mapping.enumeration.OperatorTypeMapping;
import cz.azetex.cdrgenerator.model.OperatorType;
import cz.azetex.cdrgenerator.services.OperatorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorTypeFacade {

    private final OperatorTypeService operatorTypeService;
    private final OperatorTypeMapping operatorTypeMapping;

    public ResponseDto findAllOperatorTypes() {
        ResponseDto responseDto = new ResponseDto();

        List<OperatorType> operatorTypeList = operatorTypeService.findAllOperatorTypes();

        operatorTypeList.stream()
                .map(operatorTypeMapping::toDto)
                .forEach(responseDto.getData().getOperatorTypes()::add);

        return responseDto;

    }

    public ResponseDto createOperatorType(String name) {
        ResponseDto responseDto = new ResponseDto();
        
        try {
            OperatorType savedOperatorType = operatorTypeService.saveOperatorType(name);
            responseDto.getData().getOperatorTypes().add(operatorTypeMapping.toDto(savedOperatorType));
        } catch(DataIntegrityViolationException e) {
            throw new OperatorTypeAlreadyExistsException("Operator with name '" + name + "' already exists");
        }


        return responseDto;
    }

}
