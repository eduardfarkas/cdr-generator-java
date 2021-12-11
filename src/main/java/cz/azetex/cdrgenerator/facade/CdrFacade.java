package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.PaginationDto;
import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.dto.ResponseInformationDto;
import cz.azetex.cdrgenerator.error.*;
import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.mapping.enumeration.CdrDetailMapping;
import cz.azetex.cdrgenerator.mapping.enumeration.CdrMapping;
import cz.azetex.cdrgenerator.model.*;
import cz.azetex.cdrgenerator.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CdrFacade {

    private final CdrService cdrService;
    private final GroupService groupService;
    private final OperatorTypeService operatorTypeService;
    private final DataTypeService dataTypeService;
    private final ExtensionService extensionService;
    private final CdrMapping cdrMapping;
    private final CdrDetailMapping cdrDetailMapping;
    private final Message msg;

    public ResponseDto getCdrById(Long id) {
        Cdr cdr = cdrService.findById(id)
                .orElseThrow(() -> new CdrDoesNotExistException(msg.getText("error.cdrDoesNotExist", id)));

        ResponseDto responseDto = new ResponseDto();
        responseDto.getData().getCdr().add(cdrDetailMapping.toDto(cdr));

        return responseDto;
    }

    public ResponseDto getCdrs(String operatorTypeName, String dataTypeName, String chargingClass, String chargingCode, Boolean isUsed, int page, int pageSize) {
        ResponseDto responseDto = new ResponseDto();

        PageRequest pageable = PageRequest.of(page, pageSize);

        Page<Cdr> result = cdrService.findCdrs(operatorTypeName, dataTypeName, chargingClass, chargingCode, isUsed, pageable);
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

    public ResponseDto createCdr(String name, String description, String value, Long groupId,
                                 Long extensionId, Long dataTypeId, Long operatorTypeId,
                                 String chargingClass, String chargingCode, Boolean isUsed) {

        ResponseDto responseDto = new ResponseDto();

        Group group = groupService.findById(groupId).orElseThrow(() -> new GroupDoesNotExistException(msg.getText("error.groupDoesNotExist", groupId)));
        Extension extension = extensionService.findById(extensionId).orElseThrow(() -> new ExtensionDoesNotExistException(msg.getText("error.extensionDoesNotExist", extensionId)));
        DataType dataType = dataTypeService.findById(dataTypeId).orElseThrow(() -> new DataTypeDoesNotExistException(msg.getText("error.dataTypeDoesNotExist", dataTypeId)));
        OperatorType operatorType = operatorTypeService.findById(operatorTypeId).orElseThrow(() -> new OperatorTypeDoesNotExistException(msg.getText("error.operatorTypeDoesNotExist", operatorTypeId)));

        try {
            Cdr newCdr = new Cdr();
            newCdr.setName(name);
            newCdr.setDescription(description);
            newCdr.setValue(value);
            newCdr.setGroup(group);
            newCdr.setExtension(extension);
            newCdr.setDataType(dataType);
            newCdr.setOperatorType(operatorType);
            newCdr.setChargingClass(chargingClass);
            newCdr.setChargingCode(chargingCode);
            newCdr.setIsUsed(isUsed);

            Cdr savedCdr = cdrService.saveCdr(newCdr);

            responseDto.getData().getCdrs().add(cdrMapping.toDto(savedCdr));
        } catch(DataIntegrityViolationException e) {
            throw new CdrAlreadyExistsException(msg.getText("error.cdrAlreadyExists", name));
        }

        return responseDto;
    }

    public ResponseDto updateCdr(Long id, String name, String description, String value, Long groupId,
                                      Long extensionId, Long dataTypeId, Long operatorTypeId,
                                      String chargingClass, String chargingCode, Boolean isUsed) {
        ResponseDto responseDto = new ResponseDto();

        Cdr cdr = cdrService.findById(id).orElseThrow(() -> new CdrDoesNotExistException(msg.getText("error.cdrDoesNotExist", id)));

        Group group = groupService.findById(groupId).orElseThrow(() -> new GroupDoesNotExistException(msg.getText("error.groupDoesNotExist", groupId)));
        Extension extension = extensionService.findById(extensionId).orElseThrow(() -> new ExtensionDoesNotExistException(msg.getText("error.extensionDoesNotExist", extensionId)));
        DataType dataType = dataTypeService.findById(dataTypeId).orElseThrow(() -> new DataTypeDoesNotExistException(msg.getText("error.dataTypeDoesNotExist", dataTypeId)));
        OperatorType operatorType = operatorTypeService.findById(operatorTypeId).orElseThrow(() -> new OperatorTypeDoesNotExistException(msg.getText("error.operatorTypeDoesNotExist", operatorTypeId)));

        cdr.setName(name);
        cdr.setDescription(description);
        cdr.setValue(value);
        cdr.setGroup(group);
        cdr.setExtension(extension);
        cdr.setDataType(dataType);
        cdr.setOperatorType(operatorType);
        cdr.setChargingClass(chargingClass);
        cdr.setChargingCode(chargingCode);
        cdr.setIsUsed(isUsed);

        cdrService.saveCdr(cdr);

        responseDto.getData().getCdrs().add(cdrMapping.toDto(cdr));

        return responseDto;
    }

    public ResponseDto deleteCdr(Long id) {
        ResponseDto responseDto = new ResponseDto();

        Cdr cdr = cdrService.findById(id).orElseThrow(() -> new CdrDoesNotExistException(msg.getText("error.cdrDoesNotExist", id)));

        cdrService.deleteCdr(cdr);

        responseDto.getData().setMessage(msg.getText("message.cdrDeleted", id));
        return responseDto;
    }
}