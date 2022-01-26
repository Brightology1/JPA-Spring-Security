package com.brightology.springsecurityjpa.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

class MyUserDetailsTest {
    @Test
    void testConstructor() {
        User user = new User();
        user.setActive(true);
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUserName("janedoe");
        MyUserDetails actualMyUserDetails = new MyUserDetails(user);
        assertEquals("iloveyou", actualMyUserDetails.getPassword());
        assertEquals("janedoe", actualMyUserDetails.getUsername());
        assertTrue(actualMyUserDetails.isAccountNonExpired());
        assertTrue(actualMyUserDetails.isAccountNonLocked());
        assertTrue(actualMyUserDetails.isCredentialsNonExpired());
        assertTrue(actualMyUserDetails.isEnabled());
    }

    @Test
    void testConstructor2() {
        User user = new User();
        user.setActive(true);
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUserName("janedoe");
        MyUserDetails actualMyUserDetails = new MyUserDetails(user);
        Collection<? extends GrantedAuthority> authorities = actualMyUserDetails.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(actualMyUserDetails.isEnabled());
        assertEquals("iloveyou", actualMyUserDetails.getPassword());
        assertEquals("janedoe", actualMyUserDetails.getUsername());
        assertEquals("Roles", ((List<? extends GrantedAuthority>) authorities).get(0).getAuthority());
    }

    @Test
    void testConstructor3() {
        User user = new User();
        user.setActive(false);
        user.setId(1);
        user.setPassword("iloveyou");
        user.setRoles("Roles");
        user.setUserName("janedoe");
        MyUserDetails actualMyUserDetails = new MyUserDetails(user);
        Collection<? extends GrantedAuthority> authorities = actualMyUserDetails.getAuthorities();
        assertEquals(1, authorities.size());
        assertFalse(actualMyUserDetails.isEnabled());
        assertEquals("iloveyou", actualMyUserDetails.getPassword());
        assertEquals("janedoe", actualMyUserDetails.getUsername());
        assertEquals("Roles", ((List<? extends GrantedAuthority>) authorities).get(0).getAuthority());
    }
}

