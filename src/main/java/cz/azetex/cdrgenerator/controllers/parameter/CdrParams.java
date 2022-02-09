package cz.azetex.cdrgenerator.controllers.parameter;

import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class CdrParams {

    @NotNull(message = "Chybí parametr name")
    private String name;

    private String description;

    @NotNull(message = "Chybí parametr value")
    private String value;

    @NotNull(message = "Chybí parametr groupId")
    private Long groupId;

    @NotNull(message = "Chybí parametr extensionId")
    private Long extensionId;

    @NotNull(message = "Chybí parametr dataType")
    private DataType dataType;

    @NotNull(message = "Chybí parametr operatorType")
    private OperatorType operatorType;

    @NotNull(message = "Chybí parametr chargingClass")
    private String chargingClass;

    @NotNull(message = "Chybí parametr chargingCode")
    private String chargingCode;

    @NotNull(message = "Chybí parametr isUsed")
    private Boolean isUsed;
}
