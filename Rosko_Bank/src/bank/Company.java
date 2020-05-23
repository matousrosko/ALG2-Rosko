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
public class Company extends Client{
    
    public Company(String inputName){
        name = inputName;
    }

    @Override
    public String getName() {
        return "firma" + name;
    }
}
