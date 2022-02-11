package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.enums.DataType;
import cz.azetex.cdrgenerator.model.enums.OperatorType;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperatorTypeServiceImpl implements OperatorTypeService {

    @Override
    public List<String> findAllOperatorTypes() {

        return EnumSet.allOf(OperatorType.class).stream().map(e -> e.name()).collect(Collectors.toList());

    }
}
