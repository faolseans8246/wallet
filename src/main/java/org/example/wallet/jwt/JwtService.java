package org.example.wallet.jwt;

import lombok.RequiredArgsConstructor;
import org.example.wallet.entity.Registration;
import org.example.wallet.repository.RegistrationRepos;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class JwtService implements UserDetailsService {

    private final JwtUnit jwtUnit;
    private final RegistrationRepos registrationRepos;

    public String getUsername(String token) {
        return jwtUnit.extractUsername(token);
    }

    public List<String> extractRoles(String token) {
        return jwtUnit.extractRoles(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Registration registration = registrationRepos.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(registration.getUsername(), registration.getPassword(), new ArrayList<>());
    }
}
