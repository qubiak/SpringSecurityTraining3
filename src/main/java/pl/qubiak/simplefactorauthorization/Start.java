package pl.qubiak.simplefactorauthorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.qubiak.simplefactorauthorization.Model.AppUser;
import pl.qubiak.simplefactorauthorization.Repo.AppUserRepo;

@Configuration
public class Start {

    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        AppUser appUserJanusz = new AppUser();
        appUserJanusz.setUsername("Janusz");
        appUserJanusz.setPassword(passwordEncoder.encode("Janusz123"));
        appUserJanusz.setRole("ROLE_ADMIN");
        //appUserJanusz.setEnabled(true);


        AppUser appUserBogdan = new AppUser();
        appUserBogdan.setUsername("Bogdan");
        appUserBogdan.setPassword(passwordEncoder.encode("Bogdan123"));
        appUserBogdan.setRole("ROLE_USER");
        //appUserBogdan.setEnabled(true);

        appUserRepo.save(appUserJanusz);
        appUserRepo.save(appUserBogdan);


    }
}
