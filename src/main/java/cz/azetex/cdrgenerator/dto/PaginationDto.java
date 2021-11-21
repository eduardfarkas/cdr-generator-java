package cz.azetex.cdrgenerator.dto;

import lombok.Data;

@Data
public class PaginationDto {

    protected Integer totalRecords;
    protected Integer totalPages;
    protected Integer page;
    protected Integer pageSize;


}
