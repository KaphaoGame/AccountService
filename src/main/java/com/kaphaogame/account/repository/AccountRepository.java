package com.kaphaogame.account.repository;

import com.kaphaogame.account.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByUserName(String userName);
    List<Account> findByDisplayName(String display);

}
