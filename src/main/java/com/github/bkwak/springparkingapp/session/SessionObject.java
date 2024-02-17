package com.github.bkwak.springparkingapp.session;

import com.github.bkwak.springparkingapp.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
public class SessionObject {

    private User loggedUser;

    public boolean isLogged() {
        return loggedUser != null;
    }
}
