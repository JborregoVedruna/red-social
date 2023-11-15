package org.vedrunasevilla.redsocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="emails")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idemail", nullable = false)
    private Long id;

    @Column(name="email_address", nullable = false, unique = true)
    private String address;

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonIgnoreProperties({"email", "rol", "usersToFollow", "followers"})
    private User user;

    public Email() {
    }

    public Email(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
