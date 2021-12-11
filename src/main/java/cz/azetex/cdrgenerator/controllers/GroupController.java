package cz.azetex.cdrgenerator.controllers;

import cz.azetex.cdrgenerator.dto.ResponseDto;
import cz.azetex.cdrgenerator.facade.GroupFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GroupController {

    private final GroupFacade groupFacade;

    @GetMapping("/groups")
    public ResponseDto listAllGroups() {

        return groupFacade.findAllGroups();

    }

    @PostMapping("/groups")
    public ResponseDto createGroup(@RequestParam String name) {
        return groupFacade.createGroup(name);
    }

    @PutMapping("/groups/{id}")
    public ResponseDto updateGroup(@PathVariable Long id,
                                   @RequestParam String name) {
        return groupFacade.updateGroup(id, name);
    }

    @DeleteMapping("/groups/{id}")
    public ResponseDto deleteGroup(@PathVariable Long id) {
        return groupFacade.deleteGroup(id);
    }
}
