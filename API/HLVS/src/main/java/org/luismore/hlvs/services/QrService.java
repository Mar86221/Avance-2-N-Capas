package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.entities.Token;

public interface QrService {
    Token getTokenByUserId(Long userId);
    Token generateToken(Long requestId);
    boolean updateQrDuration(Long newDuration);
    boolean scanToken(String tokenContent);
}
