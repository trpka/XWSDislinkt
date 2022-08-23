package com.example.authenticationService.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationRequest {
    private String korisnicko;
    private String password;
    public String getKorisnicko() {
        return korisnicko;
    }
    public void setKorisnicko(String korisnicko) {
        this.korisnicko = korisnicko;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    /*
    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.korisnicko;
    }

    public void setUsername(String username) {
        this.korisnicko = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

     */
}

