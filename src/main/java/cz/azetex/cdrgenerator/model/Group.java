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
@Table(name = "groups",
        uniqueConstraints = { @UniqueConstraint(name = "UniqueGroupName", columnNames = { "name" }) })
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date changed;
}
