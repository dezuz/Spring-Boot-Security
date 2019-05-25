package com.mateacademy.util;

import com.mateacademy.model.Role;
import com.mateacademy.model.UserModel;
import com.mateacademy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
public class SecurityUtil {

    @Autowired
    private UserService userService;

    public User getUser(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        User user = (User)token.getPrincipal();

        UserModel model = userService.findByFirstName(user.getUsername());

        if(Objects.isNull(model)) {
            model = new UserModel();
            Optional<GrantedAuthority> optional = user.getAuthorities().stream().findFirst();
            GrantedAuthority grantedAuthority = optional.orElse(null);
            model.setRole(Role.valueOf(grantedAuthority.getAuthority()));
            model.setFirstName(user.getUsername());
           log.info(("Create new user with name" + user.getUsername()));
        }
        else {

        }

        return null;
    }
}
