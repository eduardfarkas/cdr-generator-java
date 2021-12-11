package cz.azetex.cdrgenerator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import cz.azetex.cdrgenerator.dto.entities.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataDto {

    protected List<CdrDto> cdrs = new ArrayList<>();
    protected List<CdrDetailDto> cdr = new ArrayList<>();
    protected List<OperatorTypeDto> operatorTypes = new ArrayList<>();
    protected List<DataTypeDto> dataTypes = new ArrayList<>();
    protected List<ExtensionDto> extensions = new ArrayList<>();
    protected List<GroupDto> groups = new ArrayList<>();
    protected String message;
}
