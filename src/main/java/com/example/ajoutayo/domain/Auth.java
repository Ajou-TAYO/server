package com.example.ajoutayo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Auth {

    ADMIN("ROLE_ADMIN, ROLE_SUPERADMIN"),
    MEMBER("ROLE_MEMBER");

    private String value;
}
