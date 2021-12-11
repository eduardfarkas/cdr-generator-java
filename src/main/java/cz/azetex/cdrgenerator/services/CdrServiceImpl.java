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
    public Page<Cdr> findCdrs(String operatorTypeName, String dataTypeName, String chargingClass, String chargingCode, Boolean isUsed, Pageable pageable) {
        return cdrRepository.findCdrsByCondition(operatorTypeName, dataTypeName, chargingClass, chargingCode, isUsed, pageable);
    }

    @Override
    public Optional<Cdr> findById(Long id) {
        return cdrRepository.findById(id);
    }

    @Override
    public void deleteCdr(Cdr cdr) {
        cdrRepository.delete(cdr);
    }

    @Override
    public Cdr saveCdr(Cdr cdr) {
        return cdrRepository.save(cdr);
    }

    @Override
    public Cdr updateCdr(Cdr cdr) {
        return cdrRepository.save(cdr);
    }

}
