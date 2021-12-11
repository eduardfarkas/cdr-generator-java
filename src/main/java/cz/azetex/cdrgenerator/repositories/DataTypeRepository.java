package cz.azetex.cdrgenerator.repositories;

import cz.azetex.cdrgenerator.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {
}
