package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    List<Group> findAllGroups();

    Group saveGroup(Group group);

    Group updateGroup(Group group);

    Optional<Group> findById(Long id);

    void deleteGroup(Group group);
}
