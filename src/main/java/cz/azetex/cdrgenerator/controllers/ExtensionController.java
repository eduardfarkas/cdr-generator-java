package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.ExtensionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ExtensionController {

    private final ExtensionFacade extensionFacade;

    @GetMapping("/extensions")
    public ResponseDto listAllExtensions() {

        return extensionFacade.findAllExtensions();

    }

    @PostMapping("/extensions")
    public ResponseDto createExtension(@RequestParam String name,
                                          @RequestParam String description) {
        return extensionFacade.createExtension(name, description);
    }

    @PutMapping("/extensions/{id}")
    public ResponseDto updateExtension(@PathVariable Long id,
                                          @RequestParam String name,
                                          @RequestParam(required = false) String description) {
        return extensionFacade.updateExtension(id, name, description);
    }

    @DeleteMapping("/extensions/{id}")
    public ResponseDto deleteExtension(@PathVariable Long id) {
        return extensionFacade.deleteExtension(id);
    }

}
