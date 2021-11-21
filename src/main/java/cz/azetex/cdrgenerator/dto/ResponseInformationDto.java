package cz.azetex.cdrgenerator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseInformationDto {

    protected PaginationDto pagination;

}
