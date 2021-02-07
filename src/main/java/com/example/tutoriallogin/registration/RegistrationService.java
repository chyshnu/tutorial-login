package com.example.tutoriallogin.registration;

import com.example.tutoriallogin.appuser.AppUser;
import com.example.tutoriallogin.appuser.AppUserRole;
import com.example.tutoriallogin.appuser.AppUserService;
import com.example.tutoriallogin.registration.token.ConfirmationToken;
import com.example.tutoriallogin.registration.token.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail)
            throw new IllegalStateException("email not valid");
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));
    }

    @Transactional
    public String confirmToken(String token) {
//        ConfirmationToken confirmationToken = confirmationTokenService
        return null;
    }
}
