package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.DataTypeAlreadyExistsException;
import cz.azetex.cdrgenerator.error.DataTypeDoesNotExistException;
import cz.azetex.cdrgenerator.error.DataTypeIsUsedException;
import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.mapping.enumeration.DataTypeMapping;
import cz.azetex.cdrgenerator.model.DataType;
import cz.azetex.cdrgenerator.services.DataTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTypeFacade {

    private final DataTypeService dataTypeService;
    private final DataTypeMapping dataTypeMapping;
    private final Message msg;

    public ResponseDto findAllDataTypes() {
        ResponseDto responseDto = new ResponseDto();

        List<DataType> dataTypeList = dataTypeService.findAllDataTypes();

        dataTypeList.stream()
                .map(dataTypeMapping::toDto)
                .forEach(responseDto.getData().getDataTypes()::add);

        return responseDto;
    }

    public ResponseDto createDataType(String name) {
        ResponseDto responseDto = new ResponseDto();

        try {
            DataType newDataType = new DataType();
            newDataType.setName(name);

            DataType savedDataType = dataTypeService.saveDataType(newDataType);

            responseDto.getData().getDataTypes().add(dataTypeMapping.toDto(savedDataType));
        } catch(DataIntegrityViolationException e) {
            throw new DataTypeAlreadyExistsException(msg.getText("error.dataTypeAlreadyExists", name));
        }

        return responseDto;
    }

    public ResponseDto updateDataType(Long id, String name) {
        ResponseDto responseDto = new ResponseDto();

        DataType dataType = dataTypeService.findById(id).orElseThrow(() -> new DataTypeDoesNotExistException(msg.getText("error.dataTypeDoesNotExist", id)));

        dataType.setName(name);

        dataTypeService.saveDataType(dataType);

        responseDto.getData().getDataTypes().add(dataTypeMapping.toDto(dataType));

        return responseDto;
    }

    public ResponseDto deleteDataType(Long id) {
        ResponseDto responseDto = new ResponseDto();

        DataType dataType = dataTypeService.findById(id).orElseThrow(() -> new DataTypeDoesNotExistException(msg.getText("error.dataTypeDoesNotExist", id)));

        try {
            dataTypeService.deleteDataType(dataType);
        } catch (DataIntegrityViolationException e) {
            throw new DataTypeIsUsedException(msg.getText("error.dataTypeIsUsed", dataType.getName()));
        }

        responseDto.getData().setMessage(msg.getText("message.dataTypeDeleted", id));
        return responseDto;
    }

}
