package cn.jalyn.service;

import cn.jalyn.entiry.Account;

import java.util.List;

public interface AccountService {

    void saveAccount(Account account);

    void deleteAccount(Integer id);

    void updateAccount(Account account);

    Account findById(Integer id);

    List<Account> findAll();
}
