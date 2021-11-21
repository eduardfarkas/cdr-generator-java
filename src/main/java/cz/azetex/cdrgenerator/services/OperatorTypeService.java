package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.OperatorType;

import java.util.List;

public interface OperatorTypeService {

    List<OperatorType> findAllOperatorTypes();

    OperatorType saveOperatorType(String name);

}
