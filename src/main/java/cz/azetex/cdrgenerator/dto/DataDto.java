package cz.azetex.cdrgenerator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import cz.azetex.cdrgenerator.dto.entities.*;
import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataDto {

    protected List<CdrDto> cdrs = new ArrayList<>();
    protected List<CdrDetailDto> cdr = new ArrayList<>();
    protected List<ExtensionDto> extensions = new ArrayList<>();
    protected List<GroupDto> groups = new ArrayList<>();
    protected List<String> operatorTypes = new ArrayList<>();
    protected List<String> dataTypes = new ArrayList<>();
    protected String message;
}
