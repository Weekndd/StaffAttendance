package com.study.miniProjectV2.user.entity;

public enum UserRole {
    USER("User"),
    MANAGER("Manager")
    ;

    private final String roleType;
    UserRole(String role){
        this.roleType = role;
    }
    public String getRoleType() {
        return roleType;
    }
}
