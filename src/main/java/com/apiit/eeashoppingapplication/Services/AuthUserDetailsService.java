package com.apiit.eeashoppingapplication.Services;

import com.apiit.eeashoppingapplication.Models.AuthUserDetails;
import com.apiit.eeashoppingapplication.Repositories.UserRepository;
import com.apiit.eeashoppingapplication.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findUserByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return optionalUser
                .map(AuthUserDetails::new).get();

    }
}
