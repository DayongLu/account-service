package mega.coffee.account.controller;


import mega.coffee.account.model.Account;
import mega.coffee.account.repo.AccountRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/megacoffee/account")
public class AccountServiceController {

    private AccountRepo accountRepo;

    public AccountServiceController(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getAccount(String loginName) {

        return this.accountRepo.findAccountByLoginName(loginName);

    }


}
