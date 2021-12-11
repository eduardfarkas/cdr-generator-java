package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.DataType;

import java.util.List;
import java.util.Optional;

public interface DataTypeService {

    List<DataType> findAllDataTypes();

    DataType saveDataType(DataType dataType);

    DataType updateDataType(DataType dataType);

    void deleteDataType(DataType dataType);

    Optional<DataType> findById(Long id);
}
