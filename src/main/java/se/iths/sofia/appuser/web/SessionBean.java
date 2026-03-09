package se.iths.sofia.appuser.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.sofia.appuser.entity.AppUser;

import java.io.Serializable;

@Named
@SessionScoped
@Getter
@Setter
public class SessionBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private AppUser loggedInUser;

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public String logout() {
        loggedInUser = null; // rensa sessionen
        return "login.xhtml?faces-redirect=true";
    }

}
