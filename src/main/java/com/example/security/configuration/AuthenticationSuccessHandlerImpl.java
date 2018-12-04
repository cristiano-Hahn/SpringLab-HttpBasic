package com.example.security.configuration;

import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import com.example.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse response,
                                        Authentication auth
    ) throws IOException, ServletException {
        User user =  userRepository.findByUsername(((UserDetailsImpl) auth.getPrincipal()).getUsername());

        user.setLastLogin(new Date());
        
        userRepository.save(user);
    }
}
