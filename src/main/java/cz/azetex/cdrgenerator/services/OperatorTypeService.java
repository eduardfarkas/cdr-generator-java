package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.OperatorType;

import java.util.List;
import java.util.Optional;

public interface OperatorTypeService {

    List<OperatorType> findAllOperatorTypes();

    OperatorType saveOperatorType(OperatorType operatorType);

    OperatorType updateOperatorType(OperatorType operatorType);

    void deleteOperator(OperatorType operatorType);

    Optional<OperatorType> findById(Long id);
}
