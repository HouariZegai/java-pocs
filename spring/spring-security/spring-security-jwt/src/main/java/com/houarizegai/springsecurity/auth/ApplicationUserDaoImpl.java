package com.houarizegai.springsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.houarizegai.springsecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class ApplicationUserDaoImpl implements ApplicationUserDao {

    @Autowired
    private PasswordEncoder passwordencoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
            return Lists.newArrayList(
                    new ApplicationUser(ADMIN.getGrantedAuthorities(), "admin", passwordencoder.encode("admin"), true, true, true, true),
                    new ApplicationUser(ADMIN_TRAINEE.getGrantedAuthorities(), "fatima", passwordencoder.encode("fati"), true, true, true, true),
                    new ApplicationUser(STUDENT.getGrantedAuthorities(), "houari", passwordencoder.encode("pass"), true, true, true, true)
            );
    }
}
