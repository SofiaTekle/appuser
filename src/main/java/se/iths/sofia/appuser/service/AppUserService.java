package se.iths.sofia.appuser.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import se.iths.sofia.appuser.entity.AppUser;
import se.iths.sofia.appuser.repository.AppUserRepository;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@NoArgsConstructor
public class AppUserService {
    private static final Logger LOGGER = Logger.getLogger(AppUserService.class.getName());

    private AppUserRepository appUserRepository;

    @Inject
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Transactional
    public AppUser saveUser(AppUser user) {
        LOGGER.info("Saving user " + user.getUsername());
        return appUserRepository.save(user);
    }


    public List<AppUser> getAllUsers() {
        LOGGER.info("Fetching all users");
        return appUserRepository.findAll();
    }
    

    public AppUser findByUsername(String username) {
        LOGGER.info("Fetching user by username " + username);
        return appUserRepository.findByUsername(username);
    }
}
