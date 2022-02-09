package cz.azetex.cdrgenerator.controllers.parameter;

import cz.azetex.cdrgenerator.i18n.Message;
import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class CdrParams {

    @NotBlank(message = "Parameter 'name' is missing")
    private String name;

    private String description;

    @NotBlank(message = "Parameter 'value' is missing")
    private String value;

    @NotNull(message = "Parameter 'groupId' is missing")
    private Long groupId;

    @NotNull(message = "Parameter 'extensionId' is missing")
    private Long extensionId;

    @NotNull(message = "Parameter 'dataType' is missing")
    private DataType dataType;

    @NotNull(message = "Parameter 'operatorType' is missing")
    private OperatorType operatorType;

    @NotBlank(message = "Parameter 'chargingClass' is missing")
    private String chargingClass;

    @NotBlank(message = "Parameter 'chargingCode' is missing")
    private String chargingCode;

    @NotNull(message = "Parameter 'isUsed' is missing")
    private Boolean isUsed;
}
