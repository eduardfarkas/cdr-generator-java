package cz.azetex.cdrgenerator.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDto {

    protected PaginationDto pagination;
    protected List<Object> data = new ArrayList<>();

}