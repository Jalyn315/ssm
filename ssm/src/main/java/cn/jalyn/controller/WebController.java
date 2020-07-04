package cn.jalyn.controller;

import cn.jalyn.entiry.Account;
import cn.jalyn.exception.SysException;
import cn.jalyn.service.AccountService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    private AccountService accountService;

    /**
     * 保存一个账户
     * @param account
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(Account account, Model model){
        accountService.saveAccount(account);
        model.addAttribute("msg","保存成功!");
        return "success";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String deleteAccount(Integer id, Model model){
        System.out.println(id);
        accountService.deleteAccount(id);
        model.addAttribute("msg","删除成功!");
        return "success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAccount(Account account, Model model){
        accountService.updateAccount(account);
        model.addAttribute("msg", "更新成功!");
        return "success";
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findAccount(Integer id, Model model){
        model.addAttribute("account", accountService.findById(id));
        return "list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String finAll(Model model){
        model.addAttribute("accounts", accountService.findAll());
        return "list";
    }

    @RequestMapping(value = "/4xx", method = RequestMethod.GET)
    public String ExceptionFor4XX() throws Exception{
        try{
            int i = 1 / 0;
        }catch (Exception e){
            throw new SysException("发生在你客户端的异常，请检查你的客户端请求代码！", "400");
        }
        return "success";
    }

    @RequestMapping(value = "/5xx", method = RequestMethod.GET)
    public String ExceptionFor5XX() throws Exception{
        try{
            int i = 1 / 0;
        }catch (Exception e){
            throw new SysException("发生在你服务器端的异常，请检查你的客户端请求代码！", "500");
        }
        return "success";
    }


}
