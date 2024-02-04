/*package com.example.demo01.Services;

import com.example.demo01.Entities.User;
import com.example.demo01.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserInterface userRepository;


    public UserDetails currentUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal);
        } else {
            return null;
        }
    }

    @Autowired
    public CustomUserDetailsService(UserInterface userRepository) {
        this.userRepository = userRepository;
    }

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByusername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }
        User user = optionalUser.get();
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getUserPassword(),
                user.getAuthorities()
        );
    }
    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByusername(username);
        return optionalUser.orElse(null);
    }
    public User findBystatus(String status) {
        Optional<User> optionalUser = userRepository.findByusername(status);
        return optionalUser.orElse(null);
    }

    public User findByid(long userid) {
        Optional<User> optionalUser = userRepository.findByuserid(userid);
        return optionalUser.orElse(null);
    }

}
*/







package com.example.demo01.Services;

import com.example.demo01.Entities.User;
import com.example.demo01.Interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserInterface userRepository;

    @Autowired
    public CustomUserDetailsService(UserInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails currentUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal);
        } else {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByusername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }
        User user = optionalUser.get();

        // Kullanıcının aktif olup olmadığını kontrol edin
        if (!user.isEnabled()) {
            throw new UsernameNotFoundException("Kullanıcı aktif değil: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getUserPassword(),
                user.getAuthorities()
        );
    }

    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByusername(username);
        return optionalUser.orElse(null);
    }

    public User findByid(long userid) {
        Optional<User> optionalUser = userRepository.findByuserid(userid);
        return optionalUser.orElse(null);
    }
}



























