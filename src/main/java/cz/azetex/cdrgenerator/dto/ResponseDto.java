package cz.azetex.cdrgenerator.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDto {

    protected ResponseInformationDto meta;
//    protected DataDto data;
    protected List<Object> data = new ArrayList<>();

//    public ResponseDto() {
//        this.data = new DataDto();
//    }

}