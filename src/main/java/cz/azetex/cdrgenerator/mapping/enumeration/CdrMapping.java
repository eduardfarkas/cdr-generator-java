package cz.azetex.cdrgenerator.mapping.enumeration;

import cz.azetex.cdrgenerator.dto.CdrDto;
import cz.azetex.cdrgenerator.mapping.base.BaseMapping;
import cz.azetex.cdrgenerator.model.Cdr;

public interface CdrMapping extends BaseMapping<Cdr, CdrDto> {

    CdrDto toDto(Cdr cdr);

}
