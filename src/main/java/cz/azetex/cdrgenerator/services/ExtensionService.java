package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.Extension;

import java.util.List;
import java.util.Optional;

public interface ExtensionService {

    List<Extension> findAllExtensions();

    Extension saveExtension(Extension extension);

    Extension updateExtension(Extension extension);

    void deleteExtension(Extension extension);

    Optional<Extension> findById(Long id);
}
