package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.DataTypeFacade;
import cz.azetex.cdrgenerator.services.DataTypeService;
import cz.azetex.cdrgenerator.services.OperatorTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin
public class DataTypeController {

    private final DataTypeFacade dataTypeFacade;

    @GetMapping("/data-types")
    public ResponseDto listAllDataTypes() {

        return dataTypeFacade.findAllDataTypes();

    }
}
