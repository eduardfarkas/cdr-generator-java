package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.DataTypeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DataTypeController {

    private final DataTypeFacade dataTypeFacade;

    @GetMapping("/data-types")
    public ResponseDto listAlDataTypes() {

        return dataTypeFacade.findAllDataTypes();

    }

    @PostMapping("/data-types")
    public ResponseDto createDataType(@RequestParam String name) {
        return dataTypeFacade.createDataType(name);
    }

    @PutMapping("/data-types/{id}")
    public ResponseDto updateDataType(@PathVariable Long id,
                                          @RequestParam String name) {
        return dataTypeFacade.updateDataType(id, name);
    }

    @DeleteMapping("/data-types/{id}")
    public ResponseDto deleteDataType(@PathVariable Long id) {
        return dataTypeFacade.deleteDataType(id);
    }

}
