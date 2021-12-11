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

    @PostMapping("/operator-types")
    public ResponseDto createOperatorType(@RequestParam String name) {
        return operatorTypeFacade.createOperatorType(name);
    }

    @PutMapping("/operator-types/{id}")
    public ResponseDto updateOperatorType(@PathVariable Long id,
                                          @RequestParam String name) {
        return operatorTypeFacade.updateOperatorType(id, name);
    }

    @DeleteMapping("/operator-types/{id}")
    public ResponseDto deleteOperatorType(@PathVariable Long id) {
        return operatorTypeFacade.deleteOperatorType(id);
    }
}
