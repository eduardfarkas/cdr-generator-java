package cz.azetex.cdrgenerator.dto.entities;

import lombok.Data;

import java.util.Date;

@Data
public class CdrDto {

    protected Long id;
    protected String name;
    protected String description;
    protected String value;
    protected String chargingClass;
    protected String chargingCode;
    protected String operatorType;
    protected String dataType;
    protected String extensionName;
    protected String groupName;
    protected Boolean isUsed;
    protected Date created;
    protected Date changed;

}
