package com.gaurav.springdaosecurity.service;

import com.gaurav.springdaosecurity.entity.AppUser;
import com.gaurav.springdaosecurity.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userDetailsRepository.findById(username);
        if(appUser.isPresent()){
            AppUser actualUser = appUser.get();
            //actualUser.getAuthorityList();
            return User.withUsername(username)
                    .password(actualUser.getPassword())
                    .disabled(!actualUser.isEnabled())
                    .authorities(actualUser.getAuthorityList())
                    .build();
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }

    class GrantedAuthList implements GrantedAuthority{

        @Override
        public String getAuthority() {
            return null;
        }
    }
}
