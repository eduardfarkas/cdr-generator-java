package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.controllers.parameter.CdrParams;
import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.BadRequestException;
import cz.azetex.cdrgenerator.facade.CdrFacade;
import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.util.EnumSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CdrController {

    public final CdrFacade cdrFacade;

    @InitBinder
    public void operatorTypeBinder(DataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(OperatorType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                System.out.println("jsem tu xxx");
                if (text == null || text.isBlank()) {
                    throw new IllegalArgumentException("Prázdná nebo nevalidní hodnota typu operátora"); //TODO
                }
                System.out.println("asd asd");
                setValue(OperatorType.of(text));
            }
        });
    }
    @InitBinder
    public void dataTypeBinder(DataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(DataType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null || text.isBlank()) {
                    throw new IllegalArgumentException("Prázdná nebo nevalidní hodnota typu dat"); //TODO
                }
                setValue(DataType.of(text));
            }
        });
    }

    @GetMapping("/cdrs")
    public ResponseDto listAllCdrsByCondition(@RequestParam(required = false) String operatorType,
                                              @RequestParam(required = false) String dataType,
                                              @RequestParam(required = false) String chargingClass,
                                              @RequestParam(required = false) String chargingCode,
                                              @RequestParam(required = false) Boolean isUsed,
                                              @RequestParam int page,
                                              @RequestParam int pageSize) {

        return cdrFacade.getCdrs(operatorType, dataType, chargingClass, chargingCode, isUsed, page, pageSize);
    }

    @GetMapping("/cdrs/{id}")
    public ResponseDto listCdrDetail(@PathVariable Long id) {
        return cdrFacade.getCdrById(id);
    }

    @PostMapping("/cdrs")
    public ResponseDto createCdr(@Valid CdrParams cdrParams) {
        System.out.println(cdrParams);

//        validateDataType(cdrParams.getDataType());
//        validateOperatorType(cdrParams.getOperatorType());

        return cdrFacade.createCdr(cdrParams);
    }

    @PutMapping("/cdrs/{id}")
    public ResponseDto createCdr(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam(required = false) String description,
                                 @RequestParam String value,
                                 @RequestParam Long groupId,
                                 @RequestParam Long extensionId,
                                 @RequestParam DataType dataType,
                                 @RequestParam OperatorType operatorType,
                                 @RequestParam String chargingClass,
                                 @RequestParam String chargingCode,
                                 @RequestParam Boolean isUsed) {

        validateDataType(dataType);
        validateOperatorType(operatorType);
        return cdrFacade.updateCdr(id, name, description, value, groupId, extensionId, dataType.getName(),
                operatorType.getName(), chargingClass, chargingCode, isUsed);
    }

    @DeleteMapping("/cdrs/{id}")
    public ResponseDto deleteCdr(@PathVariable Long id) {
        return cdrFacade.deleteCdr(id);
    }

    private void validateOperatorType(OperatorType operatorType) {
        EnumSet<OperatorType> supportedTypes = EnumSet.of(
                OperatorType.POSTPAID,
                OperatorType.PREPAID,
                OperatorType.M2M
        );
        if (!supportedTypes.contains(operatorType)) {
            throw new BadRequestException("Nevalidní typ operátora. Povolené typy jsou: " + supportedTypes); // TODO
        }
    }

    private void validateDataType(DataType dataType) {
        EnumSet<DataType> supportedTypes = EnumSet.of(
                DataType.VOICE,
                DataType.SMS,
                DataType.MMS,
                DataType.DATA
        );
        if (!supportedTypes.contains(dataType)) {
            throw new BadRequestException("Nevalidní typ dat. Povolené typy jsou: " + supportedTypes); // TODO
        }
    }

}
