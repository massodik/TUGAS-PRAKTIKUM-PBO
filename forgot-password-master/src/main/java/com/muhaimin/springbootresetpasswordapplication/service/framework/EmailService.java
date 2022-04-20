package com.muhaimin.springbootresetpasswordapplication.service.framework;

import com.muhaimin.springbootresetpasswordapplication.entity.Mail;

public interface EmailService {
    void send(Mail mail);
}
