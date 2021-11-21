package cz.azetex.cdrgenerator.dto;

import lombok.Data;

@Data
public class ResponseDto {

    protected ResponseInformationDto meta;
    protected DataDto data;

    public ResponseDto() {
        this.data = new DataDto();
    }

}