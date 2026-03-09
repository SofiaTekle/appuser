package se.iths.sofia.appuser.repository;

import se.iths.sofia.appuser.entity.AppUser;

import java.util.List;

public interface AppUserRepository {

    AppUser save(AppUser user);

    List<AppUser> findAll();

    AppUser findByUsername(String username);

}
