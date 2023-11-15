package org.vedrunasevilla.redsocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idrol", nullable = false)
    private Long id;

    @Column(name="rolName", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="rol")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties({"tweets", "rol", "usersToFollow", "followers"})
    private List<User> users;
}
