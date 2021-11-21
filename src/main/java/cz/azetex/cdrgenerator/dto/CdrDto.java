package cz.azetex.cdrgenerator.dto;

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
    protected String operatorTypeName;
    protected String dataTypeName;
    protected String extensionName;
    protected String groupName;
    protected Boolean isUsed;
    protected Date created;
    protected Date changed;

}
