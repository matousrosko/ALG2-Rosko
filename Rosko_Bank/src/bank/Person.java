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
public class Person extends Client {
    
    public Person(String inputName){
        name = inputName;
    }

    @Override
    public String getName(){
        if (name.endsWith("ova")){
            return "Pani " + name;
	}
	return "Pan " + name;
    }
    
}
