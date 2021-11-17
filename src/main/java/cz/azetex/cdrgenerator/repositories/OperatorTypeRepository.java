package cz.azetex.cdrgenerator.repositories;

import cz.azetex.cdrgenerator.model.OperatorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorTypeRepository extends JpaRepository<OperatorType, Long> {

}
