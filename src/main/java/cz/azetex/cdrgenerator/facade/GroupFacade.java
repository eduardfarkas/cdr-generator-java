package cz.azetex.cdrgenerator.facade;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.error.GroupAlreadyExistsException;
import cz.azetex.cdrgenerator.error.GroupDoesNotExistException;
import cz.azetex.cdrgenerator.error.GroupIsUsedException;
import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.mapping.enumeration.GroupMapping;
import cz.azetex.cdrgenerator.model.Group;
import cz.azetex.cdrgenerator.services.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupFacade {

    private final GroupService groupService;
    private final GroupMapping groupMapping;
    private final Message msg;

    public ResponseDto findAllGroups() {
        ResponseDto responseDto = new ResponseDto();

        List<Group> groupList = groupService.findAllGroups();

        groupList.stream()
                .map(groupMapping::toDto)
                .forEach(responseDto.getData()::add);

        return responseDto;
    }

    public ResponseDto createGroup(String name) {
        ResponseDto responseDto = new ResponseDto();

        try {
            Group newGroup = new Group();
            newGroup.setName(name);

            Group savedGroup = groupService.saveGroup(newGroup);

            responseDto.getData().add(groupMapping.toDto(savedGroup));
        } catch(DataIntegrityViolationException e) {
            throw new GroupAlreadyExistsException(msg.getText("error.groupAlreadyExists", name));
        }

        return responseDto;
    }

    public ResponseDto updateGroup(Long id, String name) {
        ResponseDto responseDto = new ResponseDto();

        Group group = groupService.findById(id).orElseThrow(() -> new GroupDoesNotExistException(msg.getText("error.groupDoesNotExist", id)));

        group.setName(name);

        groupService.saveGroup(group);

        responseDto.getData().add(groupMapping.toDto(group));

        return responseDto;
    }

    public ResponseDto deleteGroup(Long id) {
        ResponseDto responseDto = new ResponseDto();

        Group group = groupService.findById(id).orElseThrow(() -> new GroupDoesNotExistException(msg.getText("error.groupDoesNotExist", id)));

        try {
            groupService.deleteGroup(group);
        } catch (DataIntegrityViolationException e) {
            throw new GroupIsUsedException(msg.getText("error.groupIsUsed", group.getName()));
        }

//        responseDto.getData().add(msg.getText("message.groupDeleted", id));
        responseDto.getData().add(group);
        return responseDto;
    }
}
