package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.Cdr;
import cz.azetex.cdrgenerator.repositories.CdrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CdrServiceImpl implements CdrService {

    private final CdrRepository cdrRepository;

    @Override
    public Page<Cdr> findCdrs(String operatorTypeName, String dataTypeName, Pageable pageable) {

        if(operatorTypeName == null && dataTypeName != null) {
            return cdrRepository.findCdrsByDataTypeName(dataTypeName, pageable);
        }
        if(operatorTypeName != null && dataTypeName == null) {
            return cdrRepository.findCdrsByOperatorName(operatorTypeName, pageable);
        }
        if(operatorTypeName != null && dataTypeName != null) {
            return cdrRepository.findCdrsByOperatorTypeNameAndDataTypeName(operatorTypeName, dataTypeName, pageable);
        }

        return cdrRepository.findAllCdrs(pageable);
    }

    @Override
    public Optional<Cdr> findById(Long id) {
        return cdrRepository.findById(id);
    }
}
