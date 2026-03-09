package se.iths.sofia.appuser.web;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.sofia.appuser.entity.AppUser;
import se.iths.sofia.appuser.service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Getter
@Setter
public class AppUserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AppUserService appUserService;

    private String username;
    private String password;

    public List<AppUser> getUsers() {
        return appUserService.getAllUsers();
    }

    public void saveUser() {
        appUserService.saveUser(new AppUser(username, password));
    }

}
