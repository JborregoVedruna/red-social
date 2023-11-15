package org.vedrunasevilla.redsocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name="publications")
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpublication")
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="users_iduser", referencedColumnName = "iduser")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties({"tweets", "usersToFollow", "followers"})
    private User author;

    @Column(name="text", nullable=false)
    private String text;

    @Column(name="media")
    private String media;

    @Column(name="createDate", nullable=false)
    private Timestamp createDate;
}
