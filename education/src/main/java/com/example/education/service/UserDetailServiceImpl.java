package com.example.education.service;

import com.example.education.model.CurrentUser;
import com.example.education.model.User;
import com.example.education.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> byEmail = userRepository.findByEmail(s);
        if (byEmail.isEmpty()){
            throw new UsernameNotFoundException("User with " + s + "does not exist");
        }

        return new CurrentUser(byEmail.get());
    }
}
