package com.houarizegai.springsecuritybasicauth.security;

import java.util.Collections;
import java.util.Set;
import static com.houarizegai.springsecuritybasicauth.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Collections.EMPTY_SET),
    ADMIN(Set.of(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
