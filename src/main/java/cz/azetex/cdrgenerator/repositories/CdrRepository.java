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
                   "join fetch c.operatorType o " +
                   "join fetch c.dataType d " +
                   "where (?1 IS NULL OR (o.name = ?1))" +
                       "and (?2 IS NULL OR (d.name = ?2))" +
                       "and (?3 IS NULL OR (c.chargingClass = ?3))" +
                       "and (?4 IS NULL OR (c.chargingCode = ?4))" +
                       "and (?5 IS NULL OR (c.isUsed = ?5))",
            countQuery = "select count(c) " +
                         "from Cdr c " +
                         "join c.operatorType o " +
                         "join c.dataType d " +
                         "where (?1 IS NULL OR (o.name = ?1))" +
                            "and (?2 IS NULL OR (d.name = ?2))" +
                            "and (?3 IS NULL OR (c.chargingClass = ?3))" +
                            "and (?4 IS NULL OR (c.chargingCode = ?4))" +
                            "and (?5 IS NULL OR (c.isUsed = ?5))")
    Page<Cdr> findCdrsByCondition(String operatorTypeName, String dataTypeName, String chargingClass, String chargingCode, Boolean isUsed, Pageable pageable);

}
