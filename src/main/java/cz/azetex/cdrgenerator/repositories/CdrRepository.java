package cz.azetex.cdrgenerator.repositories;

import cz.azetex.cdrgenerator.model.Cdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrRepository extends JpaRepository<Cdr, Long> {

    @Query("select c from Cdr c")
    Page<Cdr> findAllCdrs(Pageable pageable);

    @Query(value = "select c " +
                   "from Cdr c " +
                   "join fetch c.operator o " +
                   "where o.name = ?1",
            countQuery = "select count(c) " +
                         "from Cdr c " +
                         "join c.operator o " +
                         "where o.name = ?1")
    Page<Cdr> findCdrsByOperatorName(String operatorTypeName, Pageable pageable);

    @Query(value = "select c " +
                   "from Cdr c " +
                   "join fetch c.dataType d " +
                   "where d.name = ?1",
            countQuery = "select count(c) " +
                         "from Cdr c " +
                         "join c.dataType d " +
                         "where d.name = ?1")
    Page<Cdr> findCdrsByDataTypeName(String dataTypeName,Pageable pageable);

    @Query(value = "select c " +
                   "from Cdr c " +
                   "join fetch c.operator o " +
                   "join fetch c.dataType d " +
                   "where o.name = ?1 and " +
                   "      d.name = ?2",
            countQuery = "select count(c) " +
                         "from Cdr c " +
                         "join c.operator o " +
                         "join c.dataType d " +
                         "where o.name = ?1 and " +
                         "      d.name = ?2")
    Page<Cdr> findCdrsByOperatorTypeNameAndDataTypeName(String operatorTypeName, String dataTypeName, Pageable pageable);
}
