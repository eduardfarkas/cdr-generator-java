package cz.azetex.cdrgenerator.dto.entities;

import lombok.Data;

import java.util.Date;

@Data
public class ExtensionDto {

    protected Long id;
    protected String name;
    protected String description;
    protected Date created;
    protected Date changed;

}
