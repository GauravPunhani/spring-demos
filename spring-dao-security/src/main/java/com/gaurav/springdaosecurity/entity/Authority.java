package com.gaurav.springdaosecurity.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
public class Authority implements GrantedAuthority {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name = "authority")
    private String authority;

    /*@ManyToOne
    @JoinColumn(name = "username")
    private AppUser user;*/
    @Column(name = "username")
    private String username;

    @Override
    public String getAuthority() {
        return authority;
    }
}
