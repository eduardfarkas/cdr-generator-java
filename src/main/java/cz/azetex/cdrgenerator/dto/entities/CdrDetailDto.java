package cz.azetex.cdrgenerator.dto.entities;

import lombok.Data;

import java.util.Date;

@Data
public class CdrDetailDto {

    protected Long id;
    protected String name;
    protected String description;
    protected String value;
    protected String chargingClass;
    protected String chargingCode;
    protected OperatorTypeDto operatorType;
    protected DataTypeDto dataType;
    protected ExtensionDto extension;
    protected GroupDto group;
    protected Boolean isUsed;
    protected Date created;
    protected Date changed;

}
