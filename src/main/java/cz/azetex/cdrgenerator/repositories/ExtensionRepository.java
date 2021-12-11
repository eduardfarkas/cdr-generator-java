package cz.azetex.cdrgenerator.repositories;

import cz.azetex.cdrgenerator.model.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
}
