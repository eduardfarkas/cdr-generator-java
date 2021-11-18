package cz.azetex.cdrgenerator.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CdrResponseDto {

    private ResponseInformationDto meta;
    private List<CdrDto> data = new ArrayList<>();

}