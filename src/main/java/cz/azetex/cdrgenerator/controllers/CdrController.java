package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.CdrFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CdrController {

    public final CdrFacade cdrFacade;



    @GetMapping("/cdrs")
    public ResponseDto listAllCdrsByCondition(@RequestParam(required = false) String operatorTypeName,
                                              @RequestParam(required = false) String dataTypeName,
                                              @RequestParam(required = false) String chargingClass,
                                              @RequestParam(required = false) String chargingCode,
                                              @RequestParam(required = false) Boolean isUsed,
                                              @RequestParam int page,
                                              @RequestParam int pageSize) {

        return cdrFacade.getCdrs(operatorTypeName, dataTypeName, chargingClass, chargingCode, isUsed, page, pageSize);
    }

    @GetMapping("/cdrs/{id}")
    public ResponseDto listCdrDetail(@PathVariable Long id) {
        return cdrFacade.getCdrById(id);
    }

    @PostMapping("/cdrs")
    public ResponseDto createCdr(@RequestParam String name,
                                 @RequestParam(required = false) String description,
                                 @RequestParam String value,
                                 @RequestParam Long groupId,
                                 @RequestParam Long extensionId,
                                 @RequestParam Long dataTypeId,
                                 @RequestParam Long operatorTypeId,
                                 @RequestParam String chargingClass,
                                 @RequestParam String chargingCode,
                                 @RequestParam Boolean isUsed) {

        return cdrFacade.createCdr(name, description, value, groupId, extensionId, dataTypeId,
                                    operatorTypeId, chargingClass, chargingCode, isUsed);
    }

    @PutMapping("/cdrs/{id}")
    public ResponseDto createCdr(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam(required = false) String description,
                                 @RequestParam String value,
                                 @RequestParam Long groupId,
                                 @RequestParam Long extensionId,
                                 @RequestParam Long dataTypeId,
                                 @RequestParam Long operatorTypeId,
                                 @RequestParam String chargingClass,
                                 @RequestParam String chargingCode,
                                 @RequestParam Boolean isUsed) {

        return cdrFacade.updateCdr(id, name, description, value, groupId, extensionId, dataTypeId,
                operatorTypeId, chargingClass, chargingCode, isUsed);
    }

    @DeleteMapping("/cdrs/{id}")
    public ResponseDto deleteCdr(@PathVariable Long id) {
        return cdrFacade.deleteCdr(id);
    }
}
