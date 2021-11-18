package cz.azetex.cdrgenerator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseInformationDto {
    private String test;

    public ResponseInformationDto(String test) {
        this.test = test;
    }
}
