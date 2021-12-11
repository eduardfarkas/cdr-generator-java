package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.OperatorTypeAlreadyExistsException;
import cz.azetex.cdrgenerator.error.OperatorTypeDoesNotExistException;
import cz.azetex.cdrgenerator.error.OperatorTypeIsUsedException;
import cz.azetex.cdrgenerator.i18n.Message;
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
    private final Message msg;

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
            OperatorType newOperatorType = new OperatorType();
            newOperatorType.setName(name);

            OperatorType savedOperatorType = operatorTypeService.saveOperatorType(newOperatorType);

            responseDto.getData().getOperatorTypes().add(operatorTypeMapping.toDto(savedOperatorType));
        } catch(DataIntegrityViolationException e) {
            throw new OperatorTypeAlreadyExistsException(msg.getText("error.operatorTypeAlreadyExists", name));
        }

        return responseDto;
    }

    public ResponseDto updateOperatorType(Long id, String name) {
        ResponseDto responseDto = new ResponseDto();

        OperatorType operatorType = operatorTypeService.findById(id).orElseThrow(() -> new OperatorTypeDoesNotExistException(msg.getText("error.operatorTypeDoesNotExist", id)));

        operatorType.setName(name);

        operatorTypeService.saveOperatorType(operatorType);

        responseDto.getData().getOperatorTypes().add(operatorTypeMapping.toDto(operatorType));

        return responseDto;
    }

    public ResponseDto deleteOperatorType(Long id) {
        ResponseDto responseDto = new ResponseDto();

        OperatorType operatorType = operatorTypeService.findById(id).orElseThrow(() -> new OperatorTypeDoesNotExistException(msg.getText("error.operatorTypeDoesNotExist", id)));

        try {
            operatorTypeService.deleteOperator(operatorType);
        } catch (DataIntegrityViolationException e) {
            throw new OperatorTypeIsUsedException(msg.getText("error.operatorTypeIsUsed", operatorType.getName()));
        }

        responseDto.getData().setMessage(msg.getText("message.operatorTypeDeleted", id));
        return responseDto;
    }
}
