package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.enums.DataType;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataTypeServiceImpl implements DataTypeService {

    @Override
    public List<String> findAllDataTypes() {
        return EnumSet.allOf(DataType.class).stream().map(e -> e.name()).collect(Collectors.toList());
    }
}
