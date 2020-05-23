/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bank.Client;
import bank.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matouš
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Person("Pekar"));
        clients.add(new Person("Svecova"));
        clients.add(new Person("Skoda"));
        
        clients.get(0).addAccount(1000);
        clients.get(0).addAccount(500);
        clients.get(1).addAccount(1200);
        clients.get(2).addAccount(120);
        
        for(Client c : clients){
            System.out.println(c.getName() + " : " + c.totalBalance() + " kc");
        }
    }
    
}
