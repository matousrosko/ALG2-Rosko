/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author Matouš
 */
public class Account {
    private int balance;
	
    public Account(int amount){
        this.balance = amount;
    }
	
    public void addSum(int amount){
        this.balance += amount;
    }
	
    public void remSum(int amount){
        if (balance - amount < 0){
            System.out.println("Vyber zadane sumy neni mozny: nedostatecny zustatek na ucte");
        }else{
            this.balance -= amount;
        }
    }
	
    public int getBalance(){
        return balance;
    }
}
