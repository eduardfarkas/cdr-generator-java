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
@Table(name = "data_types",
        uniqueConstraints = { @UniqueConstraint(name = "UniqueDataTypeName", columnNames = { "name" }) })
public class DataType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date changed;

}
