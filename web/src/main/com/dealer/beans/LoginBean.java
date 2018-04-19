package main.com.dealer.beans;

import com.dealer.commons.dto.User;
import main.com.dealer.util.SessionUtils;

import com.dealer.services.inter.UserServiceInterface;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean(name = "loginBean", eager = true)
@RequestScoped
public class LoginBean {
    private String username;
    private String password;
    private User user;



    @EJB

    private UserServiceInterface userService;


    public String validateUsernamePassword() throws IOException {
        user = userService.checkUser(username);
        if (user.getPassword().equals(password)) {
            HttpSession session = SessionUtils.getSession();
            SessionUtils.setUserId(String.valueOf(user.getId()));
            return "redirect";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and Password "));
            return "login";
        }
    }

    public String registerUserNamePassword() throws IOException {
        userService.registerUser(username, password);
        HttpSession session = SessionUtils.getSession();
        System.out.println("Registration successfully");
        return "redirect";
    }



    public String login() {
        return "logout";
    }

    public String logout() {
        return "login";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}