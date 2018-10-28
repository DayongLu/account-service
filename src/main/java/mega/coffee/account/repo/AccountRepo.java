package mega.coffee.account.repo;

import mega.coffee.account.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AccountRepo extends MongoRepository<Account, String> {
    Account findAccountByLoginName(String loginName);
}
