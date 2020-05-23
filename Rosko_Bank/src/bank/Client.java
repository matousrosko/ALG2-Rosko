/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matouš
 */
public abstract class Client {
    protected String name;
    List<Account> accounts = new ArrayList<>();
    
    public void addAccount(int amount){
        accounts.add(new Account(amount));
    }
    
    public int totalBalance(){
        int total = 0;
        for(Account a : accounts){
            total += a.getBalance();
        }
        return total;
    }
    
    public abstract String getName();
}

