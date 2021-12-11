package cz.azetex.cdrgenerator.dto.entities;

import lombok.Data;

import java.util.Date;

@Data
public class GroupDto {

    protected Long id;
    protected String name;
    protected Date created;
    protected Date changed;

}
