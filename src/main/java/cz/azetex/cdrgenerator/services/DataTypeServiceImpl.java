package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.DataType;
import cz.azetex.cdrgenerator.repositories.DataTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DataTypeServiceImpl implements DataTypeService {

    private final DataTypeRepository dataTypeRepository;

    @Override
    public List<DataType> findAllDataTypes() {
        return dataTypeRepository.findAll();
    }

    @Override
    public DataType saveDataType(DataType dataType) {
        return dataTypeRepository.save(dataType);
    }

    @Override
    public DataType updateDataType(DataType dataType) {
        return dataTypeRepository.save(dataType);
    }

    @Override
    public void deleteDataType(DataType dataType) {
        dataTypeRepository.delete(dataType);
    }

    @Override
    public Optional<DataType> findById(Long id) {
        return dataTypeRepository.findById(id);
    }
}
