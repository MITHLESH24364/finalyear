package com.example.finalyear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.LoginDto;
import com.example.finalyear.entity.Login;
import com.example.finalyear.repo.LoginRepo;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login profile = loginRepo.findByUsername(username);

        if (profile == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String role = profile.getStaff()==null?"STAFF":"STUDENT";
        
        return User.builder()
                .username(profile.getUsername()) 
                .password(profile.getPassword())
                .roles(role)
                .build();
    }

    public Login regsterUser(Login login) {
        return loginRepo.save(login);
    }

    public Login login(LoginDto loginDto) {
        Login profile = loginRepo.findByUsername(loginDto.getUsername());
        if (passwordEncoder.matches(loginDto.getPassword(), profile.getPassword())) {
            return profile;
        }
        return null;
    }
    
}
