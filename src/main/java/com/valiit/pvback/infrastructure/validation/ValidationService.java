package com.valiit.pvback.infrastructure.validation;

import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.infrastructure.exception.ForbiddenException;

import java.util.Optional;

import static com.valiit.pvback.infrastructure.error.Error.INCORRECT_CREDENTIALS;

public class ValidationService {

    public static User getValidExistingUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }



}
