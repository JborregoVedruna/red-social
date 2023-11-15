package org.vedrunasevilla.redsocial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="user_info")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser_info", nullable = false)
    private Long id;

    @Column(name="address")
    private String address;

    @Column(name="birthday")
    private Date birthday;

    @OneToOne(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties({"info", "tweets", "usersToFollow", "followers"})
    private User user;

    public UserInfo() {
    }

    public UserInfo(String address, Date birthday) {
        this.address = address;
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
