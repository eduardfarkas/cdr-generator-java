package cz.azetex.cdrgenerator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataDto {

    protected List<CdrDto> cdrs = new ArrayList<>();
    protected List<OperatorTypeDto> operatorTypes = new ArrayList<>();

}
