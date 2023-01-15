package cz.azetex.cdrgenerator.repositories;

import cz.azetex.cdrgenerator.model.Cdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrRepository extends JpaRepository<Cdr, Long> {

    @Query(value = "select c " +
                   "from Cdr c " +
                   "where (?1 IS NULL OR (c.operatorType = ?1))" +
                       "and (?2 IS NULL OR (c.dataType = ?2))" +
                       "and (?3 IS NULL OR (c.chargingClass = ?3))" +
                       "and (?4 IS NULL OR (c.chargingCode = ?4))" +
                       "and (?5 IS NULL OR (c.extension.name = ?5))" +
                       "and (?6 IS NULL OR (c.group.name = ?6))" +
                       "and (?7 IS NULL OR (c.isUsed = ?7))",
            countQuery = "select count(c) " +
                         "from Cdr c " +
                         "where (?1 IS NULL OR (c.operatorType = ?1))" +
                            "and (?2 IS NULL OR (c.dataType = ?2))" +
                            "and (?3 IS NULL OR (c.chargingClass = ?3))" +
                            "and (?4 IS NULL OR (c.chargingCode = ?4))" +
                            "and (?5 IS NULL OR (c.extension.name = ?5))" +
                            "and (?6 IS NULL OR (c.group.name = ?6))" +
                            "and (?7 IS NULL OR (c.isUsed = ?7))")
    Page<Cdr> findCdrsByCondition(String operatorTypeName,
                                  String dataTypeName,
                                  String chargingClass,
                                  String chargingCode,
                                  String extensionName,
                                  String groupName,
                                  Boolean isUsed,
                                  Pageable pageable);

}
