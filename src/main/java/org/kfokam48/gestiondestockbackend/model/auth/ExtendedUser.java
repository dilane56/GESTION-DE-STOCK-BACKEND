package org.kfokam48.gestiondestockbackend.model.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kfokam48.gestiondestockbackend.model.CustomUserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


public class ExtendedUser extends CustomUserDetails {
    @Getter
    @Setter
    private long IdEntreprise;

    public ExtendedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    public ExtendedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, long idEntreprise) {
        super(username, password, authorities);
        this.IdEntreprise = idEntreprise;
    }
}
