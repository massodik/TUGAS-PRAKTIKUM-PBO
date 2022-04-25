package id.ac.uinsgd.springbootresetpassword.service.framework;

import id.ac.uinsgd.springbootresetpassword.entity.Mail;

public interface EmailService {
    void send (Mail mail);
}
