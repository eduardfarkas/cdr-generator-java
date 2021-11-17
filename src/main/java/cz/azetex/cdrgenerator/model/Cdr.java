package cz.azetex.cdrgenerator.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cdrs")
public class Cdr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private OperatorType operator;

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

    private String value;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date changed;
}
