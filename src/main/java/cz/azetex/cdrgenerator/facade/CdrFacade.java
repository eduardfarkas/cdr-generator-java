package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.controllers.parameter.CdrParams;
import cz.azetex.cdrgenerator.dto.PaginationDto;
import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.*;
import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.mapping.enumeration.CdrDetailMapping;
import cz.azetex.cdrgenerator.mapping.enumeration.CdrMapping;
import cz.azetex.cdrgenerator.model.Cdr;
import cz.azetex.cdrgenerator.model.Extension;
import cz.azetex.cdrgenerator.model.Group;
import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import cz.azetex.cdrgenerator.services.CdrService;
import cz.azetex.cdrgenerator.services.ExtensionService;
import cz.azetex.cdrgenerator.services.GroupService;
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
    private final ExtensionService extensionService;
    private final CdrMapping cdrMapping;
    private final CdrDetailMapping cdrDetailMapping;
    private final Message msg;

    public ResponseDto getCdrById(Long id) {
        Cdr cdr = cdrService.findById(id)
                .orElseThrow(() -> new CdrDoesNotExistException(msg.getText("error.cdrDoesNotExist", id)));

        ResponseDto responseDto = new ResponseDto();
        responseDto.getData().add(cdrDetailMapping.toDto(cdr));

        return responseDto;
    }

    public ResponseDto getCdrs(OperatorType operatorType, DataType dataType, String chargingClass, String chargingCode,
                               String extensionName, String groupName, Boolean isUsed, int page,
                               int pageSize) {
        ResponseDto responseDto = new ResponseDto();

        PageRequest pageable = PageRequest.of(page, pageSize);

        Page<Cdr> result = cdrService.findCdrs(operatorType, dataType, chargingClass, chargingCode, extensionName, groupName, isUsed, pageable);
        result.stream()
                .map(cdrMapping::toDto)
                .forEach(responseDto.getData()::add);

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

        responseDto.setPagination(paginationDto);
    }

    public ResponseDto createCdr(CdrParams cdrParams) {

        ResponseDto responseDto = new ResponseDto();

        Group group = groupService.findById(cdrParams.getGroupId())
            .orElseThrow(() -> new GroupDoesNotExistException(msg.getText("error.groupDoesNotExist", cdrParams.getGroupId())));
        Extension extension = extensionService.findById(cdrParams.getExtensionId())
            .orElseThrow(() -> new ExtensionDoesNotExistException(msg.getText("error.extensionDoesNotExist", cdrParams.getExtensionId())));

        try {
            Cdr newCdr = new Cdr();
            newCdr.setName(cdrParams.getName());
            newCdr.setDescription(cdrParams.getDescription());
            newCdr.setValue(cdrParams.getValue());
            newCdr.setGroup(group);
            newCdr.setExtension(extension);
            newCdr.setDataType(cdrParams.getDataType().getName());
            newCdr.setOperatorType(cdrParams.getOperatorType().getName());
            newCdr.setChargingClass(cdrParams.getChargingClass());
            newCdr.setChargingCode(cdrParams.getChargingCode());
            newCdr.setIsUsed(cdrParams.getIsUsed());

            Cdr savedCdr = cdrService.saveCdr(newCdr);

            responseDto.getData().add(cdrMapping.toDto(savedCdr));
        } catch(DataIntegrityViolationException e) {
            throw new CdrAlreadyExistsException(msg.getText("error.cdrAlreadyExists", cdrParams.getName()));
        }

        return responseDto;
    }

    public ResponseDto updateCdr(Long id, CdrParams cdrParams) {
        ResponseDto responseDto = new ResponseDto();

        Cdr cdr = cdrService.findById(id).orElseThrow(() -> new CdrDoesNotExistException(msg.getText("error.cdrDoesNotExist", id)));

        Group group = groupService.findById(cdrParams.getGroupId())
            .orElseThrow(() -> new GroupDoesNotExistException(msg.getText("error.groupDoesNotExist", cdrParams.getGroupId())));
        Extension extension = extensionService.findById(cdrParams.getExtensionId())
            .orElseThrow(() -> new ExtensionDoesNotExistException(msg.getText("error.extensionDoesNotExist", cdrParams.getExtensionId())));

        cdr.setName(cdrParams.getName());
        cdr.setDescription(cdrParams.getDescription());
        cdr.setValue(cdrParams.getValue());
        cdr.setGroup(group);
        cdr.setExtension(extension);
        cdr.setDataType(cdrParams.getDataType().getName());
        cdr.setOperatorType(cdrParams.getOperatorType().getName());
        cdr.setChargingClass(cdrParams.getChargingClass());
        cdr.setChargingCode(cdrParams.getChargingCode());
        cdr.setIsUsed(cdrParams.getIsUsed());

        cdrService.saveCdr(cdr);

        responseDto.getData().add(cdrMapping.toDto(cdr));

        return responseDto;
    }

    public ResponseDto deleteCdr(Long id) {
        ResponseDto responseDto = new ResponseDto();

        Cdr cdr = cdrService.findById(id).orElseThrow(() -> new CdrDoesNotExistException(msg.getText("error.cdrDoesNotExist", id)));

        cdrService.deleteCdr(cdr);

//        responseDto.getData().add(msg.getText("message.cdrDeleted", id));
        responseDto.getData().add(cdr);
        return responseDto;
    }
}