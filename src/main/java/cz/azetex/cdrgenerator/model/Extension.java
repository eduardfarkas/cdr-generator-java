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
@Table(name = "extensions",
        uniqueConstraints = { @UniqueConstraint(name = "UniqueExtensionName", columnNames = { "name" }) })
public class Extension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date changed;

}
