package com.example.authenticationService.model;


public enum RoleType{

    Admin(Values.Admin), User(Values.User), Owner(Values.Owner);

    RoleType(String value) {
        if (!this.name().equals(value))
            throw new IllegalArgumentException("Incorrect use of Role!");
    }

    public static class Values {
        public static final String User = "User";
        public static final String Owner = "Owner";
        public static final String Admin = "Admin";
    }

}
