package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.OperatorTypeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OperatorTypeController {

    private final OperatorTypeFacade operatorTypeFacade;

    @GetMapping("/operator-types")
    public ResponseDto listAllOperatorTypes() {

        return operatorTypeFacade.findAllOperatorTypes();

    }

    @PutMapping("/operator-types/create")
    public ResponseDto createOperatorType(@RequestParam String name) {
        return operatorTypeFacade.createOperatorType(name);
    }

}
