package cz.azetex.cdrgenerator.services;

import cz.azetex.cdrgenerator.model.Cdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CdrService {

    Page<Cdr> findCdrs(String operatorTypeName, String dataTypeName, Pageable pageable);

    Optional<Cdr> findById(Long id);
}
