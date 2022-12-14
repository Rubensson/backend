package com.portfolio.backendPortfolio.Security.Dto;

import javax.validation.constraints.NotBlank;

public class UserLogin {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    //Contrsuctor
    public UserLogin() {
    }

    public UserLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //Getter and Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
