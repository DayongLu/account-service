package mega.coffee.account;

import mega.coffee.account.model.Account;
import mega.coffee.account.repo.AccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initial(AccountRepo accountRepo) {
        return args -> {
            if(accountRepo.findAll() == null || accountRepo.findAll().size() <1){
                Account account = new Account();
                account.setLoginName("test");
                account.setPassword("test");
                accountRepo.save(account);
            }
        };
    }
}
