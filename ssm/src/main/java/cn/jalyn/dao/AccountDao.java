package cn.jalyn.dao;

import cn.jalyn.entiry.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public interface AccountDao {

    @Insert("insert into account (name,money) values (#{name}, #{money})")
    void saveAccount(Account account);

    @Delete("delete from account where id = #{id}")
    void deleteAccount(Integer id);

    @Update("update account set money = #{money} where name = #{name}")
    void updateAccount(Account account);

    @Select("select * from account where id = #{id}")
    Account findById(Integer id);

    @Select("select * from account")
    List<Account> findAll();
}
