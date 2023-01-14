package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.controllers.parameter.CdrParams;
import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.CdrFacade;
import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin
public class CdrController {

    public final CdrFacade cdrFacade;

    @GetMapping("/cdrs")
    public ResponseDto listAllCdrsByCondition(@RequestParam(required = false) OperatorType operatorType,
                                              @RequestParam(required = false) DataType dataType,
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
    public ResponseDto createCdr(@Valid @RequestBody CdrParams cdrParams) {
        return cdrFacade.createCdr(cdrParams);
    }

    @PutMapping("/cdrs/{id}")
    public ResponseDto createCdr(@PathVariable Long id,
                                 @Valid @RequestBody CdrParams cdrParams) {

        return cdrFacade.updateCdr(id, cdrParams);
    }

    @DeleteMapping("/cdrs/{id}")
    public ResponseDto deleteCdr(@PathVariable Long id) {
        return cdrFacade.deleteCdr(id);
    }

}
