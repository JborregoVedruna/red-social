package org.vedrunasevilla.redsocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser", nullable = false)
    private Long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="password", nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonProperty(access = Access.WRITE_ONLY)
    //@JsonIgnoreProperties("user")
    private Email email;

    @OneToOne(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    //@JsonProperty(access = Access.WRITE_ONLY)
    @JsonIgnoreProperties("user")
    private UserInfo info;

    @OneToMany(fetch= FetchType.EAGER, mappedBy="author", cascade= CascadeType.ALL)
    @OrderBy("createDate")
    //@JsonProperty(access = Access.WRITE_ONLY)
    @JsonIgnoreProperties("author")
    private List<Publication> tweets;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="roles_idrol", referencedColumnName = "idrol")
    //@JsonProperty(access = Access.WRITE_ONLY)
    @JsonIgnoreProperties("users")
    private Rol rol;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="users_follow_users", joinColumns={@JoinColumn(name="user_who_follows")}, inverseJoinColumns={@JoinColumn(name="user_to_follow")})
    //@JsonProperty(access = Access.WRITE_ONLY)
    @JsonIgnoreProperties("usersToFollow")
    private Set<User> usersIFollow;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="usersIFollow")
    //@JsonProperty(access = Access.WRITE_ONLY)
    @JsonIgnoreProperties("followers")
    private Set<User> followers;
}
