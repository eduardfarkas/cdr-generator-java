package cz.azetex.cdrgenerator.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@Table(name = "cdrs")
//@Table(name = "cdrs",
//        uniqueConstraints = { @UniqueConstraint(name = "UniqueCdr", columnNames = { "charging_class", "charging_code", "operator_type_id", "data_type_id", "extension_id", "is_used" }) })
public class Cdr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private OperatorType operatorType;

    @ManyToOne(fetch = FetchType.LAZY)
    private DataType dataType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Extension extension;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    private Boolean isUsed;

    private String name;

    private String chargingClass;

    private String chargingCode;

    private String description;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String value;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date changed;

}
