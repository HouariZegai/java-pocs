package com.houarizegai.springsecurity.auth;

import com.houarizegai.springsecurity.models.TempData;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
