package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.dtos.UserRegisterDTO;
import org.luismore.hlvs.domain.entities.Token;
import org.luismore.hlvs.domain.entities.User;

public interface UserService {
    void create(UserRegisterDTO info);
    User findByUsernameOrEmail(String username, String email);
    boolean checkPassword(User user, String password);
    Token registerToken(User user);
    User findByIdentifier(String identifier);
    boolean isTokenValid(User user, String token);
    Token loginWithGoogle(String idToken);
    User findById(Long userId);
}
