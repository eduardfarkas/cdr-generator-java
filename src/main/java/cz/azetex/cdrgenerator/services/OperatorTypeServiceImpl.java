package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.OperatorType;
import cz.azetex.cdrgenerator.repositories.OperatorTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OperatorTypeServiceImpl implements OperatorTypeService {

    private final OperatorTypeRepository operatorTypeRepository;

    @Override
    public List<OperatorType> findAllOperatorTypes() {
        return operatorTypeRepository.findAll();
    }

    @Override
    public OperatorType saveOperatorType(OperatorType operatorType) {
        return operatorTypeRepository.save(operatorType);
    }

    @Override
    public OperatorType updateOperatorType(OperatorType operatorType) {
        return operatorTypeRepository.save(operatorType);
    }

    @Override
    public void deleteOperator(OperatorType operatorType) {
        operatorTypeRepository.delete(operatorType);
    }

    @Override
    public Optional<OperatorType> findById(Long id) {
        return operatorTypeRepository.findById(id);
    }
}
