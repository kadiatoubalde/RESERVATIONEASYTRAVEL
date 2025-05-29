package org.reservation_backend.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends AbstractDomainClass implements GrantedAuthority {


    private String code;
    private String label;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public String getAuthority() {
        return code;
    }


    @Override
    public String toString() {
        return code;
    }
}
