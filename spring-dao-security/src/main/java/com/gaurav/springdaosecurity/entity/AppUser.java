package com.gaurav.springdaosecurity.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class AppUser {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private List<Authority> authorityList;
}
