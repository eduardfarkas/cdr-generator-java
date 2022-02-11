package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.mapping.enumeration.GroupMapping;
import cz.azetex.cdrgenerator.model.Group;
import cz.azetex.cdrgenerator.services.DataTypeService;
import cz.azetex.cdrgenerator.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataTypeFacade {
    private final DataTypeService dataTypeServiceService;

    public ResponseDto findAllDataTypes() {
        ResponseDto responseDto = new ResponseDto();

        List<String> dataTypeList = dataTypeServiceService.findAllDataTypes();

        dataTypeList.stream()
            .forEach(responseDto.getData().getDataTypes()::add);

        return responseDto;
    }
}
