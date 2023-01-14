package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.ExtensionAlreadyExistsException;
import cz.azetex.cdrgenerator.error.ExtensionDoesNotExistException;
import cz.azetex.cdrgenerator.error.ExtensionIsUsedException;
import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.mapping.enumeration.ExtensionMapping;
import cz.azetex.cdrgenerator.model.Extension;
import cz.azetex.cdrgenerator.services.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtensionFacade {

    private final ExtensionService extensionService;
    private final ExtensionMapping extensionMapping;
    private final Message msg;

    public ResponseDto findAllExtensions() {
        ResponseDto responseDto = new ResponseDto();

        List<Extension> extensionList = extensionService.findAllExtensions();

        extensionList.stream()
                .map(extensionMapping::toDto)
                .forEach(responseDto.getData()::add);

        return responseDto;
    }

    public ResponseDto createExtension(String name, String description) {
        ResponseDto responseDto = new ResponseDto();

        try {
            Extension newExtension = new Extension();
            newExtension.setName(name);
            newExtension.setDescription(description);

            Extension savedExtension = extensionService.saveExtension(newExtension);

            responseDto.getData().add(extensionMapping.toDto(savedExtension));
        } catch(DataIntegrityViolationException e) {
            throw new ExtensionAlreadyExistsException(msg.getText("error.extensionAlreadyExists", name));
        }

        return responseDto;
    }

    public ResponseDto updateExtension(Long id, String name, String description) {
        ResponseDto responseDto = new ResponseDto();

        Extension extension = extensionService.findById(id).orElseThrow(() -> new ExtensionDoesNotExistException(msg.getText("error.extensionDoesNotExist", id)));

        extension.setName(name);
        extension.setDescription(description);

        extensionService.saveExtension(extension);

        responseDto.getData().add(extensionMapping.toDto(extension));

        return responseDto;
    }

    public ResponseDto deleteExtension(Long id) {
        ResponseDto responseDto = new ResponseDto();

        Extension extension = extensionService.findById(id).orElseThrow(() -> new ExtensionDoesNotExistException(msg.getText("error.extensionDoesNotExist", id)));

        try {
            extensionService.deleteExtension(extension);
        } catch (DataIntegrityViolationException e) {
            throw new ExtensionIsUsedException(msg.getText("error.extensionIsUsed", extension.getName()));
        }

        responseDto.getData().add(msg.getText("message.extensionDeleted", id));
        return responseDto;
    }
}
