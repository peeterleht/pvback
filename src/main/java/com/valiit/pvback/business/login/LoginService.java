package com.valiit.pvback.business.login;

import com.valiit.pvback.business.Status;
import com.valiit.pvback.domain.user.User;
import com.valiit.pvback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private UserRepository userRepository;

    public void login(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE);


    }


    // todo: HAPPY PATH

    // todo: kontrolleriga samanimelised meetodid
    // todo: mida sisse ootab
    // todo: l6puks tekib mingi objekt mingist klassist (loginResponse, mida see meetod tagastab) aga alguses progedes void meetod
    // todo: Kas soovime saada systeemist andmeid v6i lisame systeemi mingeid andmeid

    // todo: Kui soovime saada andmeid
    // todo: siis on vaja ligipaasu mingile repositolrile -> vaja siin klassis private muutujat
    // todo: Repository saame Entity pealt
    // todo: Kas andmed mida parime kasutab mingit sisendit mis on custom veergudega seotud (meie enda v'lja m'eldud veerud)
    // todo: Kui jah, siis on ilmselt vaja luua uus meetod repositorysse (JPA buddy aitab)

    // todo: Kui saad p;ringuga k'tte entity objekti (v6i objektid), siis neid ei saa otse tagstada, tuleb luua uus/uued objekt/id DTO
    // todo: Kui on mingi vaga lihtsa struktuuriga objekt siis v]ib k'sitsi seda teha (new MingiKlass()) aga 9/10st aitab mapper
    // todo: DTO objekti saabki tagstada kontrollerile.


    // todo: SAD PATH
    // todo: Kas v6ib tekkida, mingi olukord, kus me soovime tagastada, mingi vea.
    // todo: Vigade s]bnumite hoidmiseks kasutada enum klassi src/main/java/com/valiit/pvback/infrastructure/error/Error.java
    // todo: Vigade kontrollimiseks kasutada ValidationService klass src/main/java/com/valiit/pvback/infrastructure/validation/ValidationService.java

}
