package com.monsource.geotsenoz.core.security;

public interface AuthDao {

    /**
     * @param username
     */
    public AuthDetails find(String username);

}