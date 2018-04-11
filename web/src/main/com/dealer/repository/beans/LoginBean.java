package com.dealer.repository.beans;

import com.dealer.repository.util.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "loginBean", eager = true)
@RequestScoped
public class LoginBean {

    private String userName;
    private String password;

    public String validateUsernamePassword() throws IOException {
        if (userName.trim().equals("root") && password.trim().equals("root")) {
            HttpSession session = SessionUtils.getSession();
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
                    (FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and Password "));
            return "login";

        }
    }

    public String login() {
        return "logout";
    }

    public String logout() {
        return "login";
    }

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
