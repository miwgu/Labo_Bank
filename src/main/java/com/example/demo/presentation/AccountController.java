package com.example.demo.presentation;

import com.example.demo.application.PersonalFinanceService;
import com.example.demo.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping(path= "/bank")

public class AccountController {

    @Autowired
    private final PersonalFinanceService personalFinanceService;

    @GetMapping(path="/start")
    public String form(){
        return "form";
    }


    @PostMapping(path="/openAccount")
    public String openAccount(@RequestParam String firstName, @RequestParam String lastName) {
        final Account account = personalFinanceService.openAccount(firstName, lastName);
        return "redirect:" + account.getCustomer().getId() + "/account/" + account.getId();
    }
    @GetMapping(path= "/{customerId}/account/{accountId}")
    public String showAccount(@PathVariable("customerId") long customerId, @PathVariable("accountId")long accountId,
                              @RequestParam(name="deposit", required=false) Long deposit,
                              @RequestParam(name="withdraw", required = false) Long withdraw, Model model){
        Account account = personalFinanceService.findAccount(customerId, accountId);
        model.addAttribute("balance", account.getBalance());
        model.addAttribute("customerId", account.getCustomer().getId());
        model.addAttribute("accountId", account.getId());
        model.addAttribute("deposit", deposit);
        model.addAttribute("withdraw", withdraw);
        return "transaction";
        }

    @PostMapping("/bank/{customerId}/account/{accountId}/deposit")
    public String deposit(@PathVariable("customerId") long customerId, @PathVariable("accountId") long accountId, @RequestParam Long deposit) {
        final Account account = personalFinanceService.deposit(customerId, accountId, deposit);
        return "redirect:" + account.getCustomer().getId() + "/account/" + account.getId();
    }

    @PostMapping("/bank/{customerId}/account/{accountId}/withdraw")
    public String withdraw(@PathVariable("customerId") Long customerId, @PathVariable("accountId") Long accountId, @RequestParam Long withdraw) {
        final Account account = personalFinanceService.withdraw(customerId, accountId, withdraw);
        return "redirect:" + account.getCustomer().getId() + "/account/" + account.getId();
    }

}

