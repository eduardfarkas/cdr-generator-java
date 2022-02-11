package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.DataTypeFacade;
import cz.azetex.cdrgenerator.facade.OperatorTypeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OperatorTypeController {

    private final OperatorTypeFacade operatorTypeFacade;

    @GetMapping("/operator-types")
    public ResponseDto listAllOperatorTypes() {

        return operatorTypeFacade.findAllOperatorTypes();

    }

}
