package id.ac.uinsgd.springbootresetpassword.service.framework;

import id.ac.uinsgd.springbootresetpassword.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    PasswordResetToken findByToken(String token);

    PasswordResetToken save(PasswordResetToken passwordResetToken);
}
