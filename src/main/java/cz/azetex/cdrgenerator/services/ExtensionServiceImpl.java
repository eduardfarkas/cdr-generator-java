package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.Extension;
import cz.azetex.cdrgenerator.repositories.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExtensionServiceImpl implements ExtensionService {

    private final ExtensionRepository extensionRepository;

    @Override
    public List<Extension> findAllExtensions() {
        return extensionRepository.findAll();
    }

    @Override
    public Extension saveExtension(Extension extension) {
        return extensionRepository.save(extension);
    }

    @Override
    public Extension updateExtension(Extension extension) {
        return extensionRepository.save(extension);
    }

    @Override
    public void deleteExtension(Extension extension) {
        extensionRepository.delete(extension);
    }

    @Override
    public Optional<Extension> findById(Long id) {
        return extensionRepository.findById(id);
    }
}
