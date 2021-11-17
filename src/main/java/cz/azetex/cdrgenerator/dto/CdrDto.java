package cz.azetex.cdrgenerator.dto;

import cz.azetex.cdrgenerator.model.Cdr;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CdrDto {
    private Long id;
    private String name;
    private String description;
    private String value;
    private String chargingClass;
    private String chargingCode;
    private String operatorTypeName;
    private String dataTypeName;
    private String extensionName;
    private String groupName;
    private Boolean isUsed;
    private Date created;
    private Date changed;

    public static CdrDto of(Cdr cdr) {
        return CdrDto.builder()
                .id(cdr.getId())
                .name(cdr.getName())
                .description(cdr.getDescription())
                .value(cdr.getValue())
                .chargingClass(cdr.getChargingClass())
                .chargingCode(cdr.getChargingCode())
                .operatorTypeName(cdr.getOperator().getName())
                .dataTypeName(cdr.getDataType().getName())
                .extensionName(cdr.getExtension().getName())
                .groupName(cdr.getGroup().getName())
                .isUsed(cdr.getIsUsed())
                .created(cdr.getCreated())
                .changed(cdr.getChanged())
                .build();
    }
}
