package com.monsource.geotsenoz.core.security;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthSupport {

    public AuthDetails getAuthDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthDetails) {
            return (AuthDetails) principal;
        }

        throw new InternalAuthenticationServiceException("User not signed in!!!");
    }

    /**
     * @param role
     */
    public boolean checkAuthority(Role role) {
        for (AuthAuthority authAuthority : this.getAuthDetails().getAuthorities()) {
            if (authAuthority.getRole().equals(role)) {
                return true;
            }
        }

        return false;
    }

}