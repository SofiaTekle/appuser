package se.iths.sofia.appuser.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.sofia.appuser.entity.AppUser;
import se.iths.sofia.appuser.service.AppUserService;

import java.io.Serializable;

@Named
@SessionScoped
@Getter
@Setter
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AppUserService appUserService;

    @Inject
    private SessionBean sessionBean;

    private String username;
    private String password;
    private String errorMessage;

    public String login() {

        AppUser user = appUserService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            sessionBean.setLoggedInUser(user); // spara i sessionen
            return "chat.xhtml?faces-redirect=true";
        } else {
            errorMessage = "Incorrect username or password";
            return null;
        }

    }


}
