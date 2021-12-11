package cz.azetex.cdrgenerator.repositories;

import cz.azetex.cdrgenerator.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
