package com.muhaimin.springbootresetpasswordapplication.service.framework;

import com.muhaimin.springbootresetpasswordapplication.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}