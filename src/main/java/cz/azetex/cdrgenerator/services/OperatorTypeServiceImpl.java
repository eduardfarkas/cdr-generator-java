package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.OperatorType;
import cz.azetex.cdrgenerator.repositories.OperatorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorTypeServiceImpl implements OperatorTypeService {

    private final OperatorTypeRepository operatorTypeRepository;

    @Override
    public List<OperatorType> findAllOperatorTypes() {
        return operatorTypeRepository.findAll();
    }

    @Override
    public OperatorType saveOperatorType(String name) {
        OperatorType operatorType = new OperatorType();

        operatorType.setName(name);
        operatorTypeRepository.save(operatorType);

        return operatorType;

    }
}
