/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparingstudents;

import java.util.Comparator;

/**
 *
 * @author Matouš
 */
public class ComparatorByAverageGrade implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.calculateAverageGrade(), o2.calculateAverageGrade());
    }
    
}
