package cz.azetex.cdrgenerator.services;

import org.springframework.stereotype.Service;

import java.util.List;

public interface OperatorTypeService {
    List<String> findAllOperatorTypes();
}
